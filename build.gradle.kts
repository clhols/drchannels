import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://plugins.gradle.org/m2/") }
        maven { setUrl("https://maven.fabric.io/public") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        maven { setUrl("https://github.com/clhols/mvn-repo/raw/master/") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:$androidGradlePlugin")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.google.gms:google-services:4.3.1")
        classpath("io.fabric.tools:gradle:1.31.0")
        classpath("dk.youtec:appupdater:1.0")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://kotlin.bintray.com/kotlinx") }
        maven { setUrl("https://plugins.gradle.org/m2/") }
        maven { setUrl("https://maven.fabric.io/public") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        //jcenter()
    }

    // Force all of the primary libraries to use the same version.
    configurations.all {
        resolutionStrategy {
            eachDependency {
                when (requested.group) {
                    "org.jetbrains.kotlin" -> useVersion(kotlinVersion)
                    "org.jetbrains.kotlinx" -> when(requested.name) {
                        "kotlinx-coroutines-core" -> useVersion(coroutinesVersion)
                    }
                    "androidx.annotation" -> useVersion(androidxVersion)
                    "androidx.exifinterface" -> useVersion(androidxVersion)
                }
            }
        }
    }

    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
        reports.html.isEnabled = false
        reports.junitXml.isEnabled = false
    }
    tasks.withType<JavaCompile> {
        options.isFork = true
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-progressive")
        }
    }
}