package dk.youtec.appupdater.plugin

import org.gradle.api.DefaultTask

open class AppUpdaterGroupTask : DefaultTask() {
    init {
        group = "appupdater"
    }
}