import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.0")
        classpath("com.github.triplet.gradle:play-publisher:1.2.0")
        classpath("com.novoda:bintray-release:0.3.4")
    }
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
        google()
    }
}

extra["kotlinVersion"] = "1.2.0"
extra["compileSdkVersion"] = 27
extra["targetSdkVersion"] = 27
extra["buildToolsVersion"] = "27.0.0"
extra["supportLibVersion"] = "27.0.2"
extra["playServicesVersion"] = "11.6.0"