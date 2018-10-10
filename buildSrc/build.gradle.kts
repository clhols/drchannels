plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    jcenter()
    google()
}

dependencies {
    compileOnly(gradleApi())
    implementation("com.android.tools.build:gradle:+")
    implementation(kotlin("stdlib"))
}