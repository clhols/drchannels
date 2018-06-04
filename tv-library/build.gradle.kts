import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue

plugins {
    id("com.android.library")
}

android {
    val compileSdkVersion: Int by rootProject.extra
    val buildToolsVersion: String by rootProject.extra
    val targetSdkVersion: Int by rootProject.extra

    compileSdkVersion(compileSdkVersion)
    buildToolsVersion(buildToolsVersion)

    defaultConfig {
        minSdkVersion(21)
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

    implementation("com.android.support:support-annotations:$supportLibVersion")
    implementation("com.android.support:support-core-utils:$supportLibVersion")
}