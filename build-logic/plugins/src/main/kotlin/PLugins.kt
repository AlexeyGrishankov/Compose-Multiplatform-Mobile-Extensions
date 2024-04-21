@file:Suppress("unused")

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import setups.androidSetup
import setups.kmpSetup

class KmpPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        with(pluginManager) {
            apply(libs.plugins.multiplatform.get().pluginId)
            apply(libs.plugins.android.library.get().pluginId)
        }
        extensions.configure<KotlinMultiplatformExtension>(::kmpSetup)
        extensions.configure<LibraryExtension>(::androidSetup)
    }
}

class CmpPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        with(pluginManager) {
            apply(libs.plugins.compose.get().pluginId)
        }
        val compose = extensions
            .getByType<ComposeExtension>().dependencies
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.commonMain.dependencies {
                implementation(compose.runtime)
            }
        }
    }
}

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        with(pluginManager) {
            apply(libs.plugins.android.application.get().pluginId)
            apply(libs.plugins.multiplatform.get().pluginId)
            apply(libs.plugins.compose.get().pluginId)
        }
        extensions.configure<ApplicationExtension>(::androidSetup)
        extensions.configure<KotlinMultiplatformExtension>(::kmpSetup)
    }
}
