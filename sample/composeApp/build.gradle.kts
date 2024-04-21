plugins {
    alias(libs.plugins.setup.application)
}

kotlin {
    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
        }
    }
}

dependencies {
    commonMainApi(compose.ui)
    commonMainApi(compose.foundation)
    commonMainApi(compose.runtime)
    commonMainApi(compose.material)

    commonMainApi(projects.themeStatusBars)
}
