import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib", kotlinVersion))
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.5.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.6")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}