plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation(kotlin("stdlib", "1.3.41"))
}