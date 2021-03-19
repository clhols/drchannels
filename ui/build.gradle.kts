plugins {
    kotlin("multiplatform") // kotlin("jvm") doesn't work well in IDEA/AndroidStudio (https://github.com/JetBrains/compose-jb/issues/22)
    id("org.jetbrains.compose")
}

kotlin {
    jvm() {
        withJava()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                api(project(":logic"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}")
                implementation("org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}")
            }
        }
    }
}