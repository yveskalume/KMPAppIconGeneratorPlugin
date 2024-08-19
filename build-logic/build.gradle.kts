plugins {
    `kotlin-dsl`
    `maven-publish`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "com.qamar.icon.generator" // Change as needed
version = "1.0.0"

gradlePlugin {
    website = "https://github.com/qamarelsafadi/KMPAppIconGeneratorPlugin"
    vcsUrl = "https://github.com/qamarelsafadi/KMPAppIconGeneratorPlugin.git"
    plugins {
        register("com.qamar.icon.generator.KMPAppIconGeneratorPlugin") {
            id = "com.qamar.icon.generator.module"
            implementationClass = "com.qamar.icon.generator.KMPAppIconGeneratorPlugin"
            displayName = "KMPAppIconGeneratorPlugin"
            description = "KMPAppIconGeneratorPlugin is a plugin that helps you change your Android and iOS app icon from one line command"
            tags = listOf("Android", "KMP" , "Kotlin", "CM")
        }
    }
}
dependencies {
    implementation(gradleApi())
    compileOnly(libs.kotlin.gradle.plugin)
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "localPluginRepository"
            url = uri("../local-plugin-repository")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_20 // Ensure compatibility with your project's Java version
    targetCompatibility = JavaVersion.VERSION_20
}

kotlin {
    jvmToolchain(20)
}