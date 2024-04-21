plugins {
    `kotlin-dsl`
    alias(libs.plugins.buildConfig)
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(libs.gradle.kotlin)
    implementation(libs.gradle.android)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.multiplatform)
    implementation(libs.plugin.compose)
}

val pluginPath = "com.cme"
val projectPath = "com.cme"

group = "$pluginPath.buildlogic"


buildConfig {
    className("BuildConfig")
    packageName("")
    buildConfigField("PROJECT_PATH", projectPath)
    generateAtSync = true
    useKotlinOutput()
}

gradlePlugin {
    plugins {
        register("android-application-setup") {
            id = "android-application-setup"
            implementationClass = "AndroidApplicationPlugin"
            version = "1.0.0"
        }
    }
    plugins {
        register("kmp-setup") {
            id = "kmp-setup"
            implementationClass = "KmpPlugin"
            version = "1.0.0"
        }
    }
    plugins {
        register("cmp-setup") {
            id = "cmp-setup"
            implementationClass = "CmpPlugin"
            version = "1.0.0"
        }
    }
}
