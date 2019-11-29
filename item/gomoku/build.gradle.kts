import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.60"
    application
}

group = "com.github.hzqd.gomoku"
version = "0.1"

application {
    mainClassName = "AppKt"
}

repositories {
    mavenCentral()
}

val arrowVersion = "0.10.1"
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    implementation("io.arrow-kt:arrow-syntax:$arrowVersion")
    implementation("io.arrow-kt:arrow-meta:$arrowVersion")
    implementation("io.arrow-kt:arrow-fx:$arrowVersion")
    implementation("io.arrow-kt:arrow-optics:$arrowVersion")
    implementation("io.arrow-kt:arrow-data:0.8.2")
    implementation("io.arrow-kt:arrow-effects:0.8.2")
    implementation("io.arrow-kt:arrow-test:$arrowVersion")
    implementation("io.arrow-kt:arrow-typeclasses:0.9.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}