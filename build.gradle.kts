import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.buildConfig).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
}

val groupLibrary: String by project
val versionLibrary: String by project

group = group
version = versionLibrary

subprojects {
    group = groupLibrary
    version = versionLibrary
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
}

tasks.register("cleanAll") {
    subprojects.forEach { subproject ->
        subproject.tasks
            .matching { it.name == "clean" }
            .forEach(::dependsOn)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
