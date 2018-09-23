import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
    id("com.github.triplet.play")
    id("org.sonarqube") version "2.6.2"
    id("dk.youtec.appupdater")
}

android {
    val compileSdkVersion: Int by rootProject.extra
    val buildToolsVersion: String by rootProject.extra
    val targetSdkVersion: Int by rootProject.extra

    compileSdkVersion(compileSdkVersion)
    buildToolsVersion(buildToolsVersion)

    flavorDimensions("app")

    if (project.hasProperty("devBuild")) {
        aaptOptions.cruncherEnabled = false
    }

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(targetSdkVersion)

        applicationId = "dk.youtec.drchannels"
        versionCode = versionCodeTimestamp
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true

        resConfigs("en", "da")

        signingConfigs {
            create("release")
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                isDebuggable = false
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

                signingConfig = signingConfigs["release"]
            }
        }

        productFlavors {
            create("mobile") {
                applicationId = "dk.youtec.drchannels.mobile"
            }
            create("tv") {
                applicationId = "dk.youtec.drchannels.tv"
            }
        }

        lintOptions {
            isCheckReleaseBuilds = false
            isCheckDependencies = true
        }
    }
}

kapt {
    useBuildCache = true
}

dependencies {
    val kotlinVersion: String by rootProject.extra
    val supportLibVersion: String by rootProject.extra
    val glideVersion: String by rootProject.extra
    val archComponentVersion: String by rootProject.extra
    val coroutinesVersion: String by rootProject.extra

    implementation(project(":drapi"))
    implementation(project(":tv-library"))
    implementation(project(":appupdater"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation("com.google.android.exoplayer:exoplayer:2.8.4")

    implementation("org.jetbrains.anko:anko-sdk15:0.10.5")
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    implementation("com.github.bumptech.glide:okhttp3-integration:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideVersion")
    implementation("com.squareup.okhttp3:okhttp:3.11.0")
    implementation("com.google.android.material:material:$supportLibVersion")
    implementation("androidx.legacy:legacy-support-v4:$supportLibVersion")
    implementation("androidx.recyclerview:recyclerview:$supportLibVersion")
    implementation("androidx.tvprovider:tvprovider:$supportLibVersion")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.core:core-ktx:1.0.0")

    implementation("androidx.lifecycle:lifecycle-extensions:$archComponentVersion")
    kapt("androidx.lifecycle:lifecycle-compiler:$archComponentVersion")
    implementation("android.arch.work:work-runtime-ktx:1.0.0+")

    implementation("io.reactivex.rxjava2:rxjava:2.2.0")
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")

    androidTestImplementation("androidx.test:runner:1.1.0+")
    androidTestImplementation("androidx.test:rules:1.1.0+")

}

play {
    jsonFile = project.file("youtec.json")

    setTrack("alpha") // 'production', 'beta' or 'alpha'
}

val releasePropertiesFile: File = rootProject.file("release.properties")
if (releasePropertiesFile.exists()) {
    val props = Properties().apply { load(releasePropertiesFile.inputStream()) }

    with(android.signingConfigs["release"]) {
        storeFile = rootProject.file(System.getProperty("user.home") + props.getProperty("keyStore"))
        storePassword = props.getProperty("keyStorePassword")
        keyAlias = props.getProperty("keyAlias")
        keyPassword = props.getProperty("keyAliasPassword")
    }
}

val versionCodeTimestamp
    get() = SimpleDateFormat("yyMMddHHmm")
            .apply { timeZone = TimeZone.getTimeZone("Europe/Copenhagen") }
            .format(Date()).toInt()