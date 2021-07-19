pluginManagement {
    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
}

/*
buildCache {
    remote(HttpBuildCache::class.java) {
        url = uri("http://svn.youtec.dk:5071/cache/")
        isPush = System.getenv("CI") == "true"
        isAllowInsecureProtocol = true
        credentials {
            username = "youtec"
            password = "QapcErxW2pSa3pR"
        }
    }
}
 */

include(":androidApp", ":tv-library", ":appupdater", ":drapi", ":logic", ":desktop", ":ui")

rootProject.buildFileName = "build.gradle.kts"