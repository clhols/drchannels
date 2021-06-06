import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}

android {
    compileSdk = Versions.compileSdk
    defaultConfig {
        minSdk = Versions.minSdk
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

multiplatformSwiftPackage {
    packageName("Logic")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("11") }
    }
    outputDirectory(File(projectDir, "build/SharedSwiftPackage"))
}


kotlin {
    android {}

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "Logic"
                export(project(":drapi"))
                export("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
            }
        }
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":drapi"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datetime}")
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
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
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
}

val packForXcode by tasks.creating(Sync::class) {
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>("ios").binaries.getFramework(mode)
    val targetDir = File(buildDir, "xcode-frameworks")

    group = "build"
    dependsOn(framework.linkTask)
    inputs.property("mode", mode)

    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)