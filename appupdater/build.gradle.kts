plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlinx-serialization")
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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
    implementation("androidx.appcompat:appcompat:$androidxVersion")
    implementation("androidx.legacy:legacy-support-v4:$androidxVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}