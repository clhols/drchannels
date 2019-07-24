import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
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
                progressiveMode = true
            }
        }
        commonMain {
            dependencies {
                api(project(":drapi"))
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common:$kotlinVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion")
            }
        }
        commonTest {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common:$kotlinVersion")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:$kotlinVersion")
            }
        }
        named("androidMain") {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
            }
        }
        named("androidTest") {
            dependencies {
            }
        }

        named("iosMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
            }
        }

        named("iosTest") {
            dependencies {
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
            include("logic.framework/**")
            include("logic.framework.dSYM")
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