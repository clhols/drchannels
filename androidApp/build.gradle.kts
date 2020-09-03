import com.google.firebase.perf.plugin.FirebasePerfExtension
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("com.github.triplet.play") version "2.3.0"
    id("org.sonarqube") version "2.7.1"
    id("dk.youtec.appupdater")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    flavorDimensions("app")

    if (project.hasProperty("devBuild")) {
        aaptOptions.cruncherEnabled = false
    }

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        applicationId = "dk.youtec.drchannels"
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true

        resConfigs("en", "da")

        signingConfigs {
            create("release")
        }

        buildTypes {
            getByName("debug") { this as ExtensionAware
                applicationIdSuffix = ".debug"
                manifestPlaceholders = mapOf(
                        "enableCrashReporting" to false,
                        "enablePerformanceMonitoring" to false
                )
                extra["alwaysUpdateBuildId"] = false
                (extensions["FirebasePerformance"] as FirebasePerfExtension).setInstrumentationEnabled(false)
            }
            getByName("release") {
                isMinifyEnabled = true
                isShrinkResources = true
                isDebuggable = false
                proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                )

                signingConfig = signingConfigs["release"]
                manifestPlaceholders = mapOf(
                        "enableCrashReporting" to true,
                        "enablePerformanceMonitoring" to true
                )
            }
        }

        productFlavors {
            create("mobile") {
                applicationIdSuffix = ".mobile"
            }
            create("tv") {
                applicationIdSuffix = ".tv"
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

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }
}

kapt {
    useBuildCache = true
    correctErrorTypes = true
    javacOptions {
        // Increase the max count of errors from annotation processors.
        // Default is 100.
        option("-Xmaxerrs", 500)
    }
}

dependencies {
    implementation(project(":logic"))
    implementation(project(":tv-library"))
    implementation(project(":appupdater"))
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:${Versions.coroutines}"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")

    implementation("com.google.android.exoplayer:exoplayer-core:${Versions.exoPlayer}")
    implementation("com.google.android.exoplayer:exoplayer-hls:${Versions.exoPlayer}")
    implementation("com.google.android.exoplayer:exoplayer-ui:${Versions.exoPlayer}")
    implementation("com.google.android.exoplayer:extension-cast:${Versions.exoPlayer}")

    implementation("io.coil-kt:coil:1.0.0-rc2")
    implementation("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
    implementation("com.google.android.material:material:1.2.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.tvprovider:tvprovider:1.0.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    implementation("androidx.preference:preference-ktx:1.1.1")
    implementation("androidx.fragment:fragment-ktx:${Versions.fragmentKtx}")
    implementation("androidx.work:work-runtime-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation(platform("com.google.firebase:firebase-bom:25.5.0"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-perf")
    implementation("com.crashlytics.sdk.android:crashlytics")
    implementation("org.koin:koin-android:2.1.6")
    implementation("org.koin:koin-androidx-viewmodel:2.1.6")

    kapt("androidx.lifecycle:lifecycle-common-java8:2.2.0")

    androidTestImplementation("androidx.test:core:1.3.0")
    androidTestImplementation("androidx.test:core-ktx:1.3.0")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.test:rules:1.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestUtil("androidx.test:orchestrator:1.3.0")
}

play {
    serviceAccountCredentials = project.file("youtec.json")

    track = "alpha" // 'production', 'beta' or 'alpha'
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

apply(mapOf("plugin" to "com.google.gms.google-services"))
