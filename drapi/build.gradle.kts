import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(compileSdk)
    defaultConfig {
        minSdkVersion(minSdk)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    // Specify Kotlin/JVM stdlib dependency.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("junit:junit:4.13")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("junit:junit:4.13")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

kotlin {
    android {}
    val frameworkName = "DrApi"
    val iosArm32 = iosArm32("iosArm32")
    val iosArm64 = iosArm64("iosArm64")
    val iosX64 = iosX64("iosX64")

    configure(listOf(iosX64, iosArm32, iosArm64)) {
        binaries.framework {
            baseName = frameworkName
            isStatic = true
            freeCompilerArgs = mutableListOf("-Xobjc-generics")
            export("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion")
        }
    }
    js {
        browser
        nodejs
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.3"
                apiVersion = "1.3"
                enableLanguageFeature("InlineClasses")
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlinx.serialization.UnstableDefault")
                useExperimentalAnnotation("kotlin.Experimental")
                progressiveMode = true
            }
        }
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("com.soywiz.korlibs.klock:klock:$klockVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
                implementation("com.soywiz.korlibs.klock:klock:$klockVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }

        named("androidMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
                implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
            }
        }
        named("androidTest") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
                implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
            }
        }

        create("iosMain") {
            dependsOn(commonMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serializationVersion")
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }
        }

        create("iosTest") {
            dependsOn(commonTest)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
            }
        }

        named("jsMain") {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationVersion")
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
        named("jsTest") {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val iosArm32Main by getting
        val iosArm64Main by getting
        val iosX64Main by getting

        configure(listOf(iosX64Main, iosArm32Main, iosArm64Main)) {
            dependsOn(getByName("iosMain"))
        }

        val iosArm32Test by getting
        val iosArm64Test by getting
        val iosX64Test by getting

        configure(listOf(iosX64Test, iosArm32Test, iosArm64Test)) {
            dependsOn(getByName("iosTest"))
        }
    }
}

task("iosTest") {
    group = "ios"
    val device = "iPhone 8"
    dependsOn("linkDebugTestIosX64")
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        val target = kotlin.targets.getByName("iosX64") as KotlinNativeTarget
        val binary = target.binaries.getTest("DEBUG").outputFile
        exec {
            commandLine = listOf("xcrun", "simctl", "spawn", device, binary.absolutePath)
        }
    }
}