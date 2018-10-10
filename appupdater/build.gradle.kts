plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildToolsVersion)

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(targetSdk)

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
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("androidx.appcompat:appcompat:$supportLibVersion")
    implementation("androidx.legacy:legacy-support-v4:$supportLibVersion")
    implementation("com.squareup.okhttp3:okhttp:3.11.0")
}