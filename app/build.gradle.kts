import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.github.triplet.play")
}

android {
    val compileSdkVersion: Int by rootProject.extra
    val buildToolsVersion: String by rootProject.extra
    val targetSdkVersion: Int by rootProject.extra

    compileSdkVersion(compileSdkVersion)
    buildToolsVersion(buildToolsVersion)

    flavorDimensions("app")

    if(project.hasProperty("devBuild")) {
        aaptOptions.cruncherEnabled = false
    }

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(targetSdkVersion)

        applicationId = "dk.youtec.drchannels"
        versionCode = versionCodeTimestamp
        versionName = "0.1"

        vectorDrawables.useSupportLibrary = true

        resConfigs("en", "da")

        signingConfigs {
            create("release")
        }

        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles("proguard-rules.pro")

                signingConfig = signingConfigs["release"]
            }
        }

        lintOptions {
            isCheckReleaseBuilds = false
        }
    }
}

dependencies {
    val kotlinVersion: String by rootProject.extra
    val supportLibVersion: String by rootProject.extra
    val playServicesVersion: String by rootProject.extra

    implementation(project(":drapi"))
    implementation(project(":tv-library"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.19.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:0.19.3")

    implementation("com.google.android.exoplayer:exoplayer:r2.5.1")

    implementation("org.jetbrains.anko:anko-sdk15:0.10.1")
    implementation("com.github.bumptech.glide:glide:4.2.0")
    implementation("com.github.bumptech.glide:okhttp3-integration:4.2.0")
    implementation("com.squareup.okhttp3:okhttp:3.9.0")
    implementation("com.android.support:design:$supportLibVersion")
    implementation("com.android.support:support-v4:$supportLibVersion")
    implementation("com.android.support:recyclerview-v7:$supportLibVersion")
    implementation("com.android.support.constraint:constraint-layout:1.0.2")
    implementation("com.google.android.gms:play-services-gcm:$playServicesVersion")

    implementation("android.arch.lifecycle:extensions:1.0.0")
    implementation("android.arch.lifecycle:reactivestreams:1.0.0")
    annotationProcessor("android.arch.lifecycle:compiler:1.0.0")

    implementation("io.reactivex.rxjava2:rxjava:2.1.2")
    implementation("io.reactivex.rxjava2:rxkotlin:2.1.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
}

play {
    jsonFile = project.file("youtec.json")

    setTrack("alpha") // 'production', 'beta' or 'alpha'
}

val releasePropertiesFile: File = rootProject.file("release.properties")
if (releasePropertiesFile.exists()) {
    val props = Properties().apply {
        load(releasePropertiesFile.inputStream())
    }

    with(android.signingConfigs["release"]) {
        storeFile = rootProject.file(System.getProperty("user.home") + props.getProperty("keyStore"))
        storePassword = props.getProperty("keyStorePassword")
        keyAlias = props.getProperty("keyAlias")
        keyPassword = props.getProperty("keyAliasPassword")
    }
}

val versionCodeTimestamp get() = SimpleDateFormat("yyMMddHHmm").format(Date()).toInt()