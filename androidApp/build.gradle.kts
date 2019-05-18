import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id("io.fabric")
    id("com.github.triplet.play") version "2.2.0"
    id("org.sonarqube") version "2.6.2"
    id("dk.youtec.appupdater")
    id("com.github.plnice.canidropjetifier") version "0.4" // ./gradlew -Pandroid.enableJetifier=false canIDropJetifier
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
        testInstrumentationRunnerArguments["clearPackageData"] = "true"

        vectorDrawables.useSupportLibrary = true

        resConfigs("en", "da")

        signingConfigs {
            create("release")
        }

        buildTypes {
            getByName("debug") {
                manifestPlaceholders = mapOf("enableCrashReporting" to false)
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
    implementation(project(":drapi"))
    implementation(project(":tv-library"))
    implementation(project(":appupdater"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation("com.google.android.exoplayer:exoplayer-core:$exoPlayerVersion")
    implementation("com.google.android.exoplayer:exoplayer-hls:$exoPlayerVersion")
    implementation("com.google.android.exoplayer:exoplayer-ui:$exoPlayerVersion")

    implementation("org.jetbrains.anko:anko-sdk21:$ankoVersion")
    implementation("com.squareup.picasso:picasso:$picassoVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.google.android.material:material:$androidxVersion")
    implementation("androidx.recyclerview:recyclerview:$androidxVersion")
    implementation("androidx.tvprovider:tvprovider:$androidxVersion")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta1")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("org.koin:koin-android:2.0.0-GA2")
    implementation("com.google.firebase:firebase-core:16.0.9")
    implementation("com.crashlytics.sdk.android:crashlytics:2.10.0")

    implementation("androidx.work:work-runtime-ktx:2.0.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$archComponentVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$archComponentVersion")
    kapt("androidx.lifecycle:lifecycle-common-java8:$archComponentVersion")

    androidTestImplementation("androidx.test:core:1.1.0")
    androidTestImplementation("androidx.test:core-ktx:1.1.0")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test:rules:1.1.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0+")
    androidTestUtil("androidx.test:orchestrator:1.1.1")
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