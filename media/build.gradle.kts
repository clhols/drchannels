/*
 * Copyright 2017 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        versionCode = 1
        versionName = "1.0"

        minSdkVersion(21)
        targetSdkVersion(29)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    api("androidx.legacy:legacy-support-core-ui:$androidxVersion")
    api("androidx.media:media:$androidxVersion")

    implementation("com.google.code.gson:gson:+")
    implementation("io.coil-kt:coil:0.7.0")

    // ExoPlayer dependencies

    // This allows UAMP to utilize a local version of ExoPlayer, which is particularly
    // useful for extending the MediaSession extension, as well as for testing and
    // customization. If the ":exoplayer-library-core" project is included, we assume
    // the others are included as well.
    if (findProject(":exoplayer-library-core") != null) {
        api(project(":exoplayer-library-core"))
        api(project(":exoplayer-library-ui"))
        api(project(":exoplayer-extension-mediasession"))
    } else {
        api("com.google.android.exoplayer:exoplayer-core:$exoPlayerVersion")
        api("com.google.android.exoplayer:exoplayer-ui:$exoPlayerVersion")
        api("com.google.android.exoplayer:extension-mediasession:$exoPlayerVersion")
    }

    // Testing
    androidTestImplementation("androidx.test:runner:1.2.0")
}
