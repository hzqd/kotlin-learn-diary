import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

group = "com.github.hzqd.arrow"
version = "1.0-SNAPSHOT"

plugins {
    java
    kotlin("jvm") version "1.3.50"
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = URI("https://dl.bintray.com/arrow-kt/arrow-kt/") }
}
val arrowVersion = "0.10.1"
dependencies {
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

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
