import groovy.lang.Closure
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id("io.fabric")
    id("com.github.triplet.play") version "2.3.0"
    id("org.sonarqube") version "2.7.1"
    id("dk.youtec.appupdater")
}

android {
    compileSdkVersion(compileSdk)
    buildToolsVersion(buildTools)

    flavorDimensions("app")

    if (project.hasProperty("devBuild")) {
        aaptOptions.cruncherEnabled = false
    }

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(targetSdk)

        applicationId = "dk.youtec.drchannels"
        versionCode = (project.ext.get("getVersionCodeTimestamp") as Closure<Int>).invoke()
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"

        vectorDrawables.useSupportLibrary = true

        resConfigs("en", "da")

        signingConfigs {
            create("release")
        }

        buildTypes {
            getByName("debug") {
                manifestPlaceholders = mapOf("enableCrashReporting" to false)
                applicationIdSuffix = ".debug"
            }
            getByName("release") {
                isMinifyEnabled = true
                isShrinkResources = true
                isDebuggable = false
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")

                signingConfig = signingConfigs["release"]
                manifestPlaceholders = mapOf("enableCrashReporting" to true)
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
        exclude("META-INF/ktor-http.kotlin_module")
        exclude("META-INF/kotlinx-serialization-runtime.kotlin_module")
        exclude("META-INF/kotlinx-io.kotlin_module")
        exclude("META-INF/atomicfu.kotlin_module")
        exclude("META-INF/ktor-utils.kotlin_module")
        exclude("META-INF/kotlinx-coroutines-io.kotlin_module")
        exclude("META-INF/ktor-client-core.kotlin_module")
        exclude("META-INF/kotlinx-coroutines-core.kotlin_module")
        exclude("META-INF/ktor-http-cio.kotlin_module")
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
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation("com.google.android.exoplayer:exoplayer-core:$exoPlayerVersion")
    implementation("com.google.android.exoplayer:exoplayer-hls:$exoPlayerVersion")
    implementation("com.google.android.exoplayer:exoplayer-ui:$exoPlayerVersion")
    implementation("com.google.android.exoplayer:extension-cast:$exoPlayerVersion")

    implementation("com.facebook.fresco:fresco:2.0.0")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.google.android.material:material:$androidxVersion")
    implementation("androidx.recyclerview:recyclerview:$androidxVersion")
    implementation("androidx.tvprovider:tvprovider:$androidxVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta2")
    implementation("androidx.preference:preference-ktx:1.1.0-rc01")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.activity:activity-ktx:1.1.0-alpha02")
    implementation("androidx.fragment:fragment-ktx:1.2.0-alpha02")
    implementation("androidx.work:work-runtime-ktx:2.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$archComponentVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$archComponentVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$archComponentVersion")
    implementation(platform("com.google.firebase:firebase-bom:20.1.0"))
    implementation("com.google.firebase:firebase-core")
    implementation("com.crashlytics.sdk.android:crashlytics")
    implementation("org.koin:koin-android:2.0.1")

    kapt("androidx.lifecycle:lifecycle-common-java8:$archComponentVersion")

    androidTestImplementation("androidx.test:core:1.2.0")
    androidTestImplementation("androidx.test:core-ktx:1.2.0")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test:rules:1.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    androidTestUtil("androidx.test:orchestrator:1.2.0")
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
