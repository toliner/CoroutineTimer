import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val atomicfu_version: String by project

buildscript {
    val atomicfu_version: String by project
    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:$atomicfu_version")
    }
}

plugins {
    kotlin("jvm") version "1.3.10"
}

apply {
    plugin("kotlinx-atomicfu")
}

group = "toliner.utils"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.1")
    compileOnly("org.jetbrains.kotlinx:atomicfu:${atomicfu_version}")
    testRuntime("org.jetbrains.kotlinx:atomicfu:${atomicfu_version}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}