import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    val compileSdkVersion: Int by rootProject.extra
    val buildToolsVersion: String by rootProject.extra
    val targetSdkVersion: Int by rootProject.extra

    compileSdkVersion(compileSdkVersion)
    buildToolsVersion(buildToolsVersion)

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(targetSdkVersion)

        versionCode = 1
        versionName = "1.0"

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
            }
        }
    }
}

dependencies {
    val supportLibVersion: String by rootProject.extra
    val kotlinVersion: String by rootProject.extra

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.24.0-eap13")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:0.24.0-eap13")
    implementation("com.android.support:support-v4:$supportLibVersion")
    implementation("com.squareup.okhttp3:okhttp:3.11.0")
}