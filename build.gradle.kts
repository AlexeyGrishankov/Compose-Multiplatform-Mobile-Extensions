import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.buildConfig).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.cocoapods).apply(false)
    alias(libs.plugins.nexusStaging)
    `maven-publish`
    signing
    publishing
}

val groupLibrary: String by project
val versionLibrary: String by project

group = group
version = versionLibrary

subprojects {
    group = groupLibrary
    version = versionLibrary
}

nexusStaging {
    serverUrl = "https://s01.oss.sonatype.org/service/local/" //required only for projects registered in Sonatype after 2021-02-24
    packageGroup = groupLibrary
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
    dependencies {
        classpath(libs.plugin.nexusStaging)
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

val local = gradleLocalProperties(rootDir)
extra.apply {
    set("signing.keyId", local["signing.keyId"])
    set("signing.password", local["signing.password"])
    set("signing.secretKeyRingFile", local["secretKeyRingFile"])
    set("ossrhUsername", local["ossrhUsername"])
    set("ossrhPassword", local["ossrhPassword"])
}

publishing {
    repositories.maven {
        val releasesRepoUrl =
            "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"

        url = uri(releasesRepoUrl)

        credentials {
            username = extra.get("ossrhUsername").toString()
            password = extra.get("ossrhPassword").toString()
        }
    }
}

signing {
    sign(publishing.publications)
}
