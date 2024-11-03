import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import kotlin.text.set

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("compile_sdk", 34)
        set("target_sdk", 34)
    }
}

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.vanniktech).apply(false)
}

// Root build.gradle.kts
subprojects {
    // Define a function that can be used by all subprojects
    extra["configurePublishing"] = { artifactId: String ->
        apply(plugin = "com.vanniktech.maven.publish")
        extensions.configure<MavenPublishBaseExtension> {
            coordinates(
                "io.github.rocxteady",
                artifactId,
                "0.0.1"
            )

            pom {
                name.set("sheets")
                description.set("Sheets")
                inceptionYear.set("2024")
                url.set("https://github.com/rocxteady/sheets/")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("rocxteady")
                        name.set("Ulaş Sancak")
                        url.set("https://github.com/rocxteady/")
                    }
                }
                scm {
                    url.set("https://github.com/rocxteady/sheets/")
                    connection.set("scm:git:git://github.com/rocxteady/sheets.git")
                    developerConnection.set("scm:git:ssh://git@github.com/rocxteady/sheets.git")
                }
            }

//            configure(KotlinMultiplatform(
//                sourcesJar = true,
//                javadocJar = JavadocJar.None()
//            ))
            publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
            signAllPublications()
        }
    }
}