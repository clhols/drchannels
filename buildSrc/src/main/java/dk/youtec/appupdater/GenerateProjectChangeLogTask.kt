package dk.youtec.appupdater

import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * Generates Project change log since last tag
 */
open class GenerateProjectChangeLogTask : AppUpdaterGroupTask() {

    init {
        description = "Generates Project change log since last tag"
    }

    @TaskAction
    fun action() {
        val tag = "git describe --tags --abbrev=0".execute(File(".")).trim()

        val log = "git log $tag..HEAD --oneline".execute(File("."))
        //println("Got log: $log")

        project.file("${project.buildDir}/appupdater.log").writeText(log)
    }
}