@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.vanniktech)
}

kotlin {
    jvmToolchain(21)

    wasmJs {
        moduleName = "sheets-m3"
        browser {
            commonWebpackConfig {
                outputFileName = "sheets-m3.js"
            }
        }
        binaries.executable()
    }

    androidTarget {
        publishLibraryVariants("release")
    }

    jvm("desktop")

    sourceSets {
        val desktopMain by getting

        commonMain.dependencies {
            api(project(":sheets-core"))
            api(compose.material3)
        }
        desktopMain.dependencies {
            api(compose.desktop.currentOs)
        }
    }
}

android {
    namespace = "io.github.rocxteady.sheets.m3"
    compileSdk = rootProject.extra["compile_sdk"] as Int

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

val configurePublishing: (String) -> Unit by extra

configurePublishing(
    "sheets-m3"
)