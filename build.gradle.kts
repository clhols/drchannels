import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories

buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0+")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.github.triplet.gradle:play-publisher:1.2.2")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    }

    // Force all of the primary libraries to use the same version.
    configurations.all {
        resolutionStrategy {
            eachDependency {
                when (requested.group) {
                    "com.android.support" -> useVersion(supportLibVersion)
                    "android.arch.core" -> useVersion(archComponentVersion)
                    "android.arch.lifecycle" -> useVersion(archComponentVersion)
                    "org.jetbrains.kotlin" -> useVersion(kotlinVersion)
                }
            }
        }
    }
}