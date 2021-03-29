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
        maven { setUrl("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.androidGradlePlugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}")
        classpath("com.google.gms:google-services:4.3.5")
        classpath("com.google.firebase:perf-plugin:1.3.5")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.5.1")
        classpath("dk.youtec:appupdater-plugin:1.1.0")
        classpath("org.jetbrains.compose:compose-gradle-plugin:0.3.2")
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
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    tasks.withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
        reports.html.isEnabled = false
        reports.junitXml.isEnabled = false
    }
    tasks.withType<JavaCompile> {
        options.isFork = true
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            useIR = true
            freeCompilerArgs = listOf(
                    "-progressive",
                    "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xopt-in=kotlinx.coroutines.FlowPreview",
                    "-Xopt-in=kotlin.RequiresOptIn",
                    "-Xopt-in=kotlin.time.ExperimentalTime",
                    "-Xjvm-default=all"
            )
        }
    }
}