plugins {
    java
    kotlin("jvm") version "1.3.60"
    application
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("org.beryx.jlink") version "2.12.0"
}

group = "com.github.hzqd"
version = "0.1"

application {
    mainClassName = "com.github.hzqd.tank.war.AppKt"
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

javafx {
    version = "13.0.1"
    modules = mutableListOf("javafx.controls")
}

jlink {
    launcher {
        name = "hellofx"
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("junit", "junit", "4.12")
    implementation("org.openjfx", "javafx-base", "13.0.1")
    implementation("org.openjfx", "javafx-graphics", "13.0.1")
    implementation("org.openjfx", "javafx-controls", "13.0.1")
    implementation("org.openjfx", "javafx-media", "13.0.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
