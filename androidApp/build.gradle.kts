import com.google.firebase.perf.plugin.FirebasePerfExtension
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
    kotlin("kapt")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("org.sonarqube") version "2.7.1"
    //id("dk.youtec.appupdater") //TODO Re-add when AGP 7.0.0 is released
}

android {
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    flavorDimensions += "app"

    buildFeatures {
        compose = true
        // Disable unused AGP features
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        applicationId = "dk.youtec.drchannels"
        versionName = "1.0.0"
        versionCode = 1 //TODO Remove when appupdater plugin is readded
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables.useSupportLibrary = true

        resourceConfigurations += listOf("en", "da")

        signingConfigs {
            create("release")
        }

        buildTypes {
            getByName("debug") {
                this as ExtensionAware
                applicationIdSuffix = ".debug"
                addManifestPlaceholders(mapOf(
                        "enableCrashReporting" to false,
                        "enablePerformanceMonitoring" to false
                ))
                extra["alwaysUpdateBuildId"] = false
                (extensions["FirebasePerformance"] as FirebasePerfExtension).setInstrumentationEnabled(false)
            }
            getByName("release") {
                isMinifyEnabled = true
                isDebuggable = false
                proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                )

                signingConfig = signingConfigs["release"]
                addManifestPlaceholders(mapOf(
                        "enableCrashReporting" to true,
                        "enablePerformanceMonitoring" to true
                ))
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

        lint {
            isCheckReleaseBuilds = false
            isCheckDependencies = true
            isAbortOnError = false
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
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
    implementation(project(":ui"))
    implementation(project(":logic"))
    implementation(project(":tv-library"))
    implementation(project(":appupdater"))
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:${Versions.coroutines}"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datetime}")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation("com.google.android.exoplayer:exoplayer-core:${Versions.exoPlayer}")
    implementation("com.google.android.exoplayer:exoplayer-hls:${Versions.exoPlayer}")
    implementation("com.google.android.exoplayer:exoplayer-ui:${Versions.exoPlayer}")
    implementation("com.google.android.exoplayer:extension-cast:${Versions.exoPlayer}")

    implementation("io.coil-kt:coil:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
    implementation("androidx.navigation:navigation-compose:1.0.0-alpha10")
    implementation("dev.chrisbanes.accompanist:accompanist-coil:0.6.2")

    implementation("com.squareup.okhttp3:okhttp:${Versions.okhttp}")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.tvprovider:tvprovider:1.0.0")
    implementation("androidx.mediarouter:mediarouter:1.2.3")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.preference:preference-ktx:1.1.1")
    implementation("androidx.work:work-runtime-ktx:2.5.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01")
    implementation(platform("com.google.firebase:firebase-bom:+"))
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-perf")
    implementation("org.koin:koin-android:2.2.1")
    implementation("org.koin:koin-androidx-viewmodel:2.2.1")
    //implementation("org.koin:koin-androidx-compose:2.2.1")

    androidTestImplementation("androidx.test:core:1.3.0")
    androidTestImplementation("androidx.test:core-ktx:1.3.0")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.test:rules:1.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestUtil("androidx.test:orchestrator:1.3.0")
}

configurations {
    implementation.get().exclude(module = "protobuf-lite")
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
