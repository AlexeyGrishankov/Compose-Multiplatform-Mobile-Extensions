import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.setup.kmp)
    alias(libs.plugins.setup.cmp)
    alias(libs.plugins.maven.plugin)
}

dependencies {
    androidMainApi(libs.androidx.activityCompose)
    commonMainApi(compose.ui)
}

mavenPublishing {
    coordinates(
        group.toString(),
        "cme-theme-status-bars",
        version.toString()
    )

    pom {
        name.set("CME Status Bars")
        description.set("Extensions for Compose Multiplatform Mobile")
        inceptionYear.set("2024")
        url.set("https://github.com/aagrishankov/Compose-Multiplatform-Mobile-Extensions")

        licenses {
            license {
                name.set("Apache-2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0")
            }
        }

        developers {
            developer {
                id.set("aagrishankov")
                name.set("Alexey Grishankov")
                email.set("domian844@gmail.com")
            }
        }

        scm {
            url.set("https://github.com/aagrishankov/Compose-Multiplatform-Mobile-Extensions")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}

task("testClasses") {}
