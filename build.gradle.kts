import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.repositories

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }

    val kotlinVersion by extra("1.2.40")

    dependencies {
        classpath("com.android.tools.build:gradle:3.2+")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.github.triplet.gradle:play-publisher:1.2.0")
        classpath("com.novoda:bintray-release:0.3.4")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}

val kotlinVersion by extra("1.2.40")
val compileSdkVersion by extra(27)
val targetSdkVersion by extra(27)
val buildToolsVersion by extra("27.0.3")
val supportLibVersion by extra("27.0.2")
val playServicesVersion by extra("11.8.0")