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
    implementation("com.android.tools.build:gradle:3.2.0")
    implementation(kotlin("stdlib", "1.2.71"))
}