import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }

    val kotlinVersion by extra("1.2.51")

    dependencies {
        classpath("com.android.tools.build:gradle:3.2+")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.github.triplet.gradle:play-publisher:1.2.0")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}

val kotlinVersion by extra("1.2.51")
val compileSdkVersion by extra(28)
val targetSdkVersion by extra(28)
val buildToolsVersion by extra("28.0.0")
val supportLibVersion by extra("27.1.1")