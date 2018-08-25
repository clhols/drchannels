package dk.youtec.appupdater

import org.gradle.api.DefaultTask

open class AppUpdaterGroupTask : DefaultTask() {
    init {
        group = "appupdater"
    }
}