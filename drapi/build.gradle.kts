import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(compileSdk)
    defaultConfig {
        minSdkVersion(21)
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
    iosX64("ios") {
        binaries {
            framework {
                // Disable bitcode embedding for the simulator build.
                embedBitcode("disable")
                isStatic = true
                freeCompilerArgs.add("-Xobjc-generics")
            }
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.3"
                apiVersion = "1.3"
                enableLanguageFeature("InlineClasses")
                useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes")
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
                implementation("com.soywiz.korlibs.klock:klock-android:$klockVersion")
            }
        }
        named("androidTest") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
                implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
                implementation("com.soywiz.korlibs.klock:klock-android:$klockVersion")
            }
        }

        named("iosMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:$serializationVersion")
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
                implementation("com.soywiz.korlibs.klock:klock-iosx64:$klockVersion")
            }
        }

        named("iosTest") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
            }
        }
    }
}

task("buildFramework") {
    group = "ios"
    val buildType: String = project.findProperty("kotlin.build.type")?.toString() ?: "DEBUG"
    dependsOn("link${buildType.toLowerCase().capitalize()}FrameworkIos")

    doLast {
        val target = kotlin.targets.getByName("ios") as KotlinNativeTarget
        val srcFile = target.binaries.getFramework(buildType).outputFile
        val targetDir = project.property("configuration.build.dir").toString()
        copy {
            from(srcFile.parent)
            into(targetDir)
            include("drapi.framework/**")
            include("drapi.framework.dSYM")
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
        val binary = target.binaries.getExecutable("test", "DEBUG").outputFile
        exec {
            commandLine = listOf("xcrun", "simctl", "spawn", device, binary.absolutePath)
        }
    }
}