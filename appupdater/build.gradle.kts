plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildToolsVersion)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(targetSdk)

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
            }
        }
    }
}

androidExtensions { isExperimental = true }

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
    implementation("org.jetbrains.kotlin:kotlin-android-extensions-runtime:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}