package dk.youtec.appupdater

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtraPropertiesExtension
import java.util.*

open class AppUpdaterPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project.tasks) {
            val generateProjectChangeLog = create("generateProjectChangeLog",
                    GenerateProjectChangeLogTask::class.java)

            create("tagProject", TagProjectTask::class.java).setMustRunAfter(listOf(
                    generateProjectChangeLog))

            whenTaskAdded {
                if (name.startsWith("generate")
                        && name.endsWith("ReleaseBuildConfig")) {
                    //println("Task name: ${task.name}")

                    dependsOn("tagProject")
                    dependsOn("generateProjectChangeLog")
                }
            }
        }

        val ext = project.extensions.getByName("ext") as ExtraPropertiesExtension

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