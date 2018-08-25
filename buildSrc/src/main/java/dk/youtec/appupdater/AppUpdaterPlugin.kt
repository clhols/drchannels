package dk.youtec.appupdater

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.plugins.DefaultExtraPropertiesExtension
import java.util.*

open class AppUpdaterPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project.tasks) {
            val generateProjectChangeLog = create("generateProjectChangeLog",
                    GenerateProjectChangeLogTask::class.java)

            create("tagProject", TagProjectTask::class.java).setMustRunAfter(listOf(
                    generateProjectChangeLog))

            whenTaskAdded(Action {
                if (name.startsWith("generate")
                        && name.endsWith("ReleaseBuildConfig")) {
                    //println("Task name: ${task.name}")

                    dependsOn("tagProject")
                    dependsOn("generateProjectChangeLog")
                }
            })
        }

        val ext = project.extensions.getByName("ext") as DefaultExtraPropertiesExtension

        //Equivalent to project.ext.getVersionCodeTimestamp = { -> }
        ext.set("getVersionCodeTimestamp", closure {
            if (project.hasProperty("devBuild")) {
                1
            } else {
                dateFormat("yyMMddHHmm").format(Date()).toInt()
            }
        })
    }
}