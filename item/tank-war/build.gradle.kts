import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
    application
}
application {
    mainClassName = "com.github.hzqd.tank.war.AppKt"
}
dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.openjfx","javafx-controls","11",classifier = "linux")
    compile("com.github.shaunxiao:kotlinGameEngine:v0.0.4")
    compile("de.dynamicfiles.projects.gradle.plugins","javafx-gradle-plugin","8.8.2")
}
repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}