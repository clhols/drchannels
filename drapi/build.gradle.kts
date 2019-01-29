import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCompilation
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

group = "dk.youtec"
version = "1.0"

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(18)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    // Specify Kotlin/JVM stdlib dependency.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("junit:junit:4.12")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("junit:junit:4.12")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test")
    androidTestImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

kotlin {
    fun NamedDomainObjectContainer<KotlinNativeCompilation>.setupForIos() {
        this["main"].apply {
            outputKinds("framework")
            source(sourceSets.maybeCreate("iosMain"))
        }
        this["test"].source(sourceSets.maybeCreate("iosTest"))
    }

    android {}
    iosArm32 { compilations.setupForIos() }
    iosArm64 { compilations.setupForIos() }
    iosX64 {
        compilations.setupForIos()
        binaries {
            framework {
                // Disable bitcode embedding for the simulator build.
                embedBitcode("disable")
            }
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                languageVersion = "1.3"
                apiVersion = "1.3"
                enableLanguageFeature("InlineClasses")
                useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes")
                progressiveMode = true
            }
        }
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.10.0")
                implementation("io.ktor:ktor-client-core:1.1.2")
                implementation("com.soywiz:klock:1.1.1")
            }
        }
        commonTest {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common")
                implementation("com.soywiz:klock:1.1.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.10.0")
                implementation("com.squareup.okhttp3:okhttp:3.12.1")
                implementation("com.squareup.okhttp3:logging-interceptor:3.12.0")
                implementation("io.ktor:ktor-client-okhttp:1.1.1")
            }
        }
        val androidTest by getting {
            dependencies {
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.1.2")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:0.10.0")
            }
        }
        val iosTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.1.1")
            }
        }
    }
}

task("copyFramework") {
    group = "ios"
    val buildType: String = project.findProperty("kotlin.build.type")?.toString() ?: "DEBUG"
    dependsOn("link${buildType.toLowerCase().capitalize()}FrameworkIosX64")

    doLast {
        val target = kotlin.targets.getByName("iosX64") as KotlinNativeTarget
        val srcFile = target.binaries.getFramework(buildType).outputFile
        val targetDir = project.property("configuration.build.dir").toString()
        copy {
            from(srcFile)
            into(targetDir)
            include("drapi.framework/**")
            include("drapi.framework.dSYM")
        }
    }
}

task("iosTest") {
    group = "ios"
    val device = "iPhone 8"
    dependsOn("linkTestDebugExecutableIosX64")
    description = "Runs tests for target 'ios' on an iOS simulator"

    doLast {
        val target = kotlin.targets.getByName("iosX64") as KotlinNativeTarget
        val binary = target.binaries.getExecutable("test", "DEBUG").outputFile
        exec {
            commandLine = listOf("xcrun", "simctl", "spawn", device, binary.absolutePath)
        }
    }
}