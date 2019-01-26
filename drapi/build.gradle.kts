import java.lang.System.getProperty

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

group = "dk.youtec"
version = "1.0"

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(18)
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

    iosX64 {
        compilations["main"].outputKinds("framework")
        binaries {
            framework {
                val buildForDevice = false
                // Disable bitcode embedding for the simulator build.
                if (!buildForDevice) {
                    embedBitcode("disable")
                }
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
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.10.0")
                implementation("io.ktor:ktor-client-core:1.1.2")
                implementation("com.soywiz:klock:1.1.1")
            }
        }
        commonTest {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
                implementation("com.soywiz:klock:1.1.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.10.0")
                implementation("com.squareup.okhttp3:okhttp:3.12.1")
                implementation("com.squareup.okhttp3:logging-interceptor:3.12.0")
                implementation("io.ktor:ktor-client-okhttp:1.1.1")
            }
        }
        val androidTest by getting {
            dependencies {
            }
        }
        val iosX64Main by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.1.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:0.10.0")
            }
        }
        val iosX64Test by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.1.1")
            }
        }
    }
}

task("copyFramework") {
    val buildType: String = project.findProperty("kotlin.build.type")?.toString() ?: "DEBUG"
    dependsOn("link${buildType.toLowerCase().capitalize()}FrameworkIosX64")

    doLast {
        val srcFile = file("build/bin/iosX64/debugFramework/")
        val targetDir = getProperty("configuration.build.dir")
        copy {
            from(srcFile)
            into(targetDir)
            include("drapi.framework/**")
            include("drapi.framework.dSYM")
        }
    }
}

task("iosTest") {
    val device = project.findProperty("iosDevice")?.toString() ?: "iPhone 8"
    dependsOn("linkTestDebugExecutableIos")
    group = JavaBasePlugin.VERIFICATION_GROUP
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        val binary = kotlin.iosX64().compilations["test"].getBinary("EXECUTABLE", "DEBUG")
        exec {
            commandLine = listOf("xcrun", "simctl", "spawn", device, binary.absolutePath)
        }
    }
}