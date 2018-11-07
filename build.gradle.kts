buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
        //maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$androidGradlePlugin")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.github.triplet.gradle:play-publisher:1.2.2")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven { setUrl("https://kotlin.bintray.com/kotlinx") }
        //maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap") }
    }

    // Force all of the primary libraries to use the same version.
    configurations.all {
        resolutionStrategy {
            eachDependency {
                when (requested.group) {
                    "org.jetbrains.kotlin" -> useVersion(kotlinVersion)
                }
            }
        }
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
        kotlinOptions {
            freeCompilerArgs = listOf("-progressive")
        }
    }
}