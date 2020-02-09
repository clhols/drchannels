import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
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

kotlin {
    android {}
    val iosArm64 = iosArm64("iosArm64")
    val frameworkName = "DrLogic"

    //select iOS target platform depending on the Xcode environment variables
    val iosTarget: (String) -> KotlinNativeTarget =
            if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
                ::iosArm64
            else
                ::iosX64
    val iosXcode = iosTarget("iosXcode")

    configure(listOf(iosXcode, iosArm64)) {
        binaries.framework {
            baseName = frameworkName
            isStatic = true
            freeCompilerArgs = mutableListOf("-Xobjc-generics")
            export(project(":drapi"))
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.3"
                apiVersion = "1.3"
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlinx.coroutines.FlowPreview")
                useExperimentalAnnotation("kotlinx.serialization.UnstableDefault")
                useExperimentalAnnotation("kotlin.Experimental")
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
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
            }
        }
        named("androidTest") {
            dependencies {
            }
        }

        create("iosMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
            }
        }

        create("iosTest") {
            dependencies {
            }
        }

        val iosArm64Main by getting
        val iosXcodeMain by getting

        configure(listOf(iosXcodeMain, iosArm64Main)) {
            dependsOn(getByName("iosMain"))
        }
    }

    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("debugFatFramework") {
        group = "ios"
        baseName = frameworkName
        description = "Builds a universal (fat) debug framework"

        from(iosXcode.binaries.getFramework("DEBUG"))
    }

    tasks.register<org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask>("releaseFatFramework") {
        group = "ios"
        baseName = frameworkName
        description = "Builds a universal (fat) release framework"

        from(iosArm64.binaries.getFramework("RELEASE"))
    }
}

//Called by XCode build script
val packForXcode by tasks.creating(Sync::class) {
    group = "ios"
    val targetDir = File(buildDir, "xcode-frameworks")

    /// selecting the right configuration for the iOS
    /// framework depending on the environment
    /// variables set by Xcode build
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
            .getByName<KotlinNativeTarget>("iosXcode")
            .binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from({ framework.outputDirectory })
    into(targetDir)

    /// generate a helpful ./gradlew wrapper with embedded Java path
    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText("#!/bin/bash\n"
                + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
                + "cd '${rootProject.rootDir}'\n"
                + "./gradlew \$@\n")
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)

task("iosTest") {
    group = "ios"
    val device = "iPhone 8"
    dependsOn("linkDebugTestIosXcode")
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        val target = kotlin.targets.getByName("iosXcode") as KotlinNativeTarget
        val binary = target.binaries.getTest("DEBUG").outputFile
        exec {
            commandLine = listOf("xcrun", "simctl", "spawn", device, binary.absolutePath)
        }
    }
}