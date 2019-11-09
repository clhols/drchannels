pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
            if (requested.id.id == "com.android.library") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
            if (requested.id.id == "com.android.application") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }

    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://plugins.gradle.org/m2/") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        //jcenter()
    }
}

buildCache {
    remote(HttpBuildCache::class.java) {
        url = uri("http://192.168.87.91:5071/cache/")
        isPush = System.getenv("CI") == "true"
        credentials {
            username = "youtec"
            password = "QapcErxW2pSa3pR"
        }
    }
}

enableFeaturePreview("GRADLE_METADATA")

include(":androidApp", ":tv-library", ":appupdater", ":drapi", ":logic")

rootProject.buildFileName = "build.gradle.kts"