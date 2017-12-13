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

val kotlinVersion by extra("1.2.10")
val compileSdkVersion by extra(27)
val targetSdkVersion by extra(27)
val buildToolsVersion by extra("27.0.2")
val supportLibVersion by extra("27.0.2")
val playServicesVersion by extra("11.6.0")