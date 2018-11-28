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
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildToolsVersion)

    flavorDimensions("app")

    if (project.hasProperty("devBuild")) {
        aaptOptions.cruncherEnabled = false
    }

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(targetSdk)

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
                isMinifyEnabled = true
                isShrinkResources = true
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
            isAbortOnError = false
        }
    }

    compileOptions {
        setSourceCompatibility("1.8")
        setTargetCompatibility("1.8")
    }
}

kapt {
    useBuildCache = true
}

dependencies {
    implementation(project(":drapi"))
    implementation(project(":tv-library"))
    implementation(project(":appupdater"))
    implementation(project(":drapi-lib"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation("com.google.android.exoplayer:exoplayer:2.9.1")

    implementation("org.jetbrains.anko:anko-sdk15:0.10.5")
    implementation("com.squareup.picasso:picasso:$picassoVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.google.android.material:material:$supportLibVersion")
    implementation("androidx.legacy:legacy-support-v4:$supportLibVersion")
    implementation("androidx.recyclerview:recyclerview:$supportLibVersion")
    implementation("androidx.tvprovider:tvprovider:$supportLibVersion")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0+")
    implementation("androidx.core:core-ktx:1.0.1")

    implementation("androidx.lifecycle:lifecycle-extensions:$archComponentVersion")
    kapt("androidx.lifecycle:lifecycle-compiler:$archComponentVersion")
    implementation("android.arch.work:work-runtime-ktx:1.0.0+")

    implementation("io.reactivex.rxjava2:rxjava:2.2.0")
    implementation("io.reactivex.rxjava2:rxkotlin:2.2.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.0")

    androidTestImplementation("androidx.test:core:1.0.0")
    androidTestImplementation("androidx.test:runner:1.1.0")
    androidTestImplementation("androidx.test:rules:1.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.0.0")
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
