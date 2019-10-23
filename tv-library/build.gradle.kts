plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildTools)

    defaultConfig {
        minSdkVersion(minSdk)
        targetSdkVersion(targetSdk)

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")
            }
        }
    }
}

dependencies {
    implementation("androidx.annotation:annotation:$androidAnnotation")
    implementation("androidx.fragment:fragment-ktx:1.2.0-rc01")
    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.0.0")
}