plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:3.6+")
    implementation(kotlin("stdlib", "1.3.40"))
}