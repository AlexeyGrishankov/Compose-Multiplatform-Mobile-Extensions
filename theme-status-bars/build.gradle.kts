plugins {
    alias(libs.plugins.setup.kmp)
    alias(libs.plugins.setup.cmp)
}

dependencies {
    androidMainApi(libs.androidx.activityCompose)
    commonMainApi(compose.ui)
}
