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
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}

kotlin {
    android {}
    val frameworkName = "Shared"
    ios {
        binaries.framework {
            baseName = frameworkName
            isStatic = true
            export(project(":drapi"))
        }
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":drapi"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.1.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}")
            }
        }

        val jvmMain by getting {
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}")
                implementation("org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}")
            }
        }

        val androidMain by getting {
            dependsOn(jvmMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
            }
        }
        val androidTest by getting {
            dependsOn(jvmTest)
            dependencies {}
        }

        val iosMain by getting {
            dependencies {}
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
}

fun targets(type: String, vararg targets: KotlinNativeTarget): List<Framework> {
    return targets.map {
        it.binaries.getFramework(type)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)