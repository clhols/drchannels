import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://plugins.gradle.org/m2/") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        maven { setUrl("https://github.com/clhols/mvn-repo/raw/master/") }
        //mavenLocal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.androidGradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
        classpath("com.google.gms:google-services:4.3.3")
        classpath("com.google.firebase:perf-plugin:1.3.1")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.2.0")
        classpath("dk.youtec:appupdater-plugin:1.0.5")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://kotlin.bintray.com/kotlinx") }
        maven { setUrl("https://kotlin.bintray.com/ktor") }
        maven { setUrl("https://plugins.gradle.org/m2/") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        //maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        //jcenter()
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
            useIR = true
            freeCompilerArgs = listOf(
                    "-progressive",
                    "-Xjvm-default=enable"
            )
        }
    }
}