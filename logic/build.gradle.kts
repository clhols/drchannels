import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        minSdkVersion(Versions.minSdk)
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
    val frameworkName = "DrLogic"

    ios {
        binaries.framework {
            baseName = frameworkName
            isStatic = true
            export(project(":drapi"))
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.4"
                apiVersion = "1.4"
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlinx.coroutines.FlowPreview")
                useExperimentalAnnotation("kotlin.Experimental")
                progressiveMode = true
            }
        }

        val commonMain by getting {
            dependencies {
                api(project(":drapi"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
            }
        }
        val androidTest by getting {
            dependencies {}
        }

        val iosMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}") {
                    version {
                        strictly(Versions.coroutines)
                    }
                }
            }
        }
        val iosTest by getting {
            dependencies {}
        }
    }

    //Build tasks for fat frameworks
    val iosArm64 = targets.getByName<KotlinNativeTarget>("iosArm64")
    val iosX64 = targets.getByName<KotlinNativeTarget>("iosX64")
    tasks.register<FatFrameworkTask>("debugFatFramework") {
        group = "ios"
        baseName = frameworkName
        description = "Builds a universal (fat) debug framework"

        from(targets("DEBUG", iosArm64, iosX64))
    }
    tasks.register<FatFrameworkTask>("releaseFatFramework") {
        group = "ios"
        baseName = frameworkName
        description = "Builds a universal (fat) release framework"

        from(targets("RELEASE", iosArm64, iosX64))
    }

    //Build task for XCode build script
    task("packForXcode") {
        group = "ios"

        dependsOn("debugFatFramework")

        /// generate a helpful ./gradlew wrapper with embedded Java path
        doLast {
            val targetDir = File(buildDir, "fat-framework")
            val gradlew = File(targetDir, "gradlew")
            gradlew.writeText("#!/bin/bash\n"
                    + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
                    + "cd '${rootProject.rootDir}'\n"
                    + "./gradlew \$@\n")
            gradlew.setExecutable(true)
        }
    }
}

fun targets(type: String, vararg targets: KotlinNativeTarget): List<Framework> {
    return targets.map {
        it.binaries.getFramework(type)
    }
}