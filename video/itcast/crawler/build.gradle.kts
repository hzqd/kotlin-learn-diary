import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
}

group = "com.github.hzqd.crawler"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.httpcomponents", "httpclient", "4.5.10")
    implementation("org.slf4j", "slf4j-log4j12", "1.7.28")
    implementation("org.jsoup", "jsoup", "1.12.1")
    testCompile("junit","junit","4.12")
    implementation("commons-io","commons-io","2.6")
    implementation("org.apache.commons","commons-lang3","3.9")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}