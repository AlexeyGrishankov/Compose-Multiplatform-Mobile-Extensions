package setups

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun kmpSetup(
    extension: KotlinMultiplatformExtension,
) = extension.apply {

    androidTarget {
        publishLibraryVariants()
    }

    iosArm64()
    iosX64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets.all {
        languageSettings {
            //TODO add opt-ins
        }
    }
}
