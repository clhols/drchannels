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

    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("junit:junit:4.12")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

kotlin {
    android {}

    //select iOS target platform depending on the Xcode environment variables
    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
            if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
                ::iosArm64
            else
                ::iosX64
    iosTarget("ios") {
        binaries {
            framework {
                baseName = "DrApi"
                isStatic = true
                freeCompilerArgs = mutableListOf("-Xobjc-generics")
            }
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
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("com.soywiz.korlibs.klock:klock:$klockVersion")
            }
        }
        commonTest {
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

        named("iosMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serializationVersion")
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }
        }
        named("iosTest") {
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
    }
}

task("iosTest") {
    group = "ios"
    val device = "iPhone 8"
    dependsOn("linkDebugTestIos")
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        val target = kotlin.targets.getByName("ios") as KotlinNativeTarget
        val binary = target.binaries.getTest("DEBUG").outputFile
        exec {
            commandLine = listOf("xcrun", "simctl", "spawn", device, binary.absolutePath)
        }
    }
}