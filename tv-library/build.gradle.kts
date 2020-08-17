plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
            }
        }
    }
}

dependencies {
    implementation("androidx.annotation:annotation:${Versions.androidAnnotation}")
    implementation("androidx.fragment:fragment-ktx:${Versions.fragmentKtx}")
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.0.0")
}