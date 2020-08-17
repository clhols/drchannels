plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlinx-serialization")
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

dependencies {
    testImplementation("junit:junit:4.13")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("junit:junit:4.13")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

kotlin {
    android {}
    val frameworkName = "DrApi"

    ios {
        binaries.framework {
            baseName = frameworkName
            isStatic = true
            export("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
        }
    }
    // Uncomment this to fix native dependency resolution in the IDE.
    //iosX64("ios") // DO NOT COMMIT THIS UNCOMMENTED
    macosX64 {
        binaries {
            executable {}
        }
    }
    linuxX64 {
        binaries {
            executable {}
        }
    }
    js {
        browser()
        nodejs()
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.4"
                apiVersion = "1.4"
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlin.Experimental")
                progressiveMode = true
            }
        }

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.serialization}")
                implementation("io.ktor:ktor-client-core:${Versions.ktor}")
                implementation("io.ktor:ktor-client-json:${Versions.ktor}")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
                implementation("io.ktor:ktor-utils:${Versions.ktor}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
                implementation("io.ktor:ktor-utils:${Versions.ktor}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:${Versions.ktor}")
                implementation("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
                implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:${Versions.ktor}")
                implementation("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
                implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}")
            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-client-serialization:${Versions.ktor}")
            }
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }

        val desktopMain by creating {
            dependsOn(nativeMain)
            dependencies {
                implementation("io.ktor:ktor-client-curl:${Versions.ktor}")
            }
        }
        val desktopTest by creating {
            dependsOn(nativeTest)
        }

        val iosMain by getting {
            dependsOn(nativeMain)
            dependencies {
                implementation("io.ktor:ktor-client-ios:${Versions.ktor}")
            }
        }

        val iosTest by getting {
            dependsOn(nativeTest)
        }

        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:${Versions.ktor}")
                implementation("io.ktor:ktor-client-serialization-js:${Versions.ktor}")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }

        val linuxX64Main by getting {
            dependencies {
                implementation(fileTree("src/linuxX64Main/libs") { include("*.klib") })
            }
            dependsOn(desktopMain)
        }
        val linuxX64Test by getting {
            dependsOn(desktopTest)
        }

        val macosX64Main by getting {
            dependencies {
                implementation(fileTree("src/macosX64Main/libs") { include("*.klib") })
            }
            dependsOn(desktopMain)
        }
        val macosX64Test by getting {
            dependsOn(desktopTest)
        }
    }
}