plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildToolsVersion)

    defaultConfig {
        minSdkVersion(21)
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
    implementation("androidx.annotation:annotation:$androidxVersion")
    implementation("androidx.legacy:legacy-support-core-utils:$androidxVersion")
}