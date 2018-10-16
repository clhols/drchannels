import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup.okhttp3:okhttp:3.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.4.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.6")

    testImplementation("junit:junit:4.12")
}