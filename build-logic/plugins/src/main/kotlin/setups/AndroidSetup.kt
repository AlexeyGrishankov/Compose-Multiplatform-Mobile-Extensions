package setups

import BuildConfig.PROJECT_PATH
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import libs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get

internal fun Project.androidSetup(
    extension: LibraryExtension,
) = extension.apply {

    val moduleName = path
        .drop(1)
        .replace("-", "_")
        .replace(":", ".")

    namespace = if (moduleName.isNotEmpty()) "$PROJECT_PATH.$moduleName" else PROJECT_PATH

    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets["main"].res.srcDirs("src/commonMain/resources", "src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")
}

internal fun Project.androidSetup(
    extension: ApplicationExtension,
) = extension.apply {

    namespace = PROJECT_PATH.plus(".sample")

    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = PROJECT_PATH.plus(".sample")
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.compileSdk.get().toInt()
        versionCode = 1
        versionName = "0.0.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    sourceSets["main"].res.srcDirs("src/commonMain/resources", "src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = false
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}
