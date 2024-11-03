@file:OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.vanniktech)
}

kotlin {
    jvmToolchain(21)

    wasmJs {
        moduleName = "sheets-sample"
        browser {
            commonWebpackConfig {
                outputFileName = "sheets-sample.js"
            }
        }
        binaries.executable()
    }

    androidTarget {
    }

    jvm("desktop")

    sourceSets {
        commonMain.dependencies {
            implementation(project(":sheets-core"))
            implementation(project(":sheets"))
            implementation(project(":sheets-m3"))
            implementation(compose.material)
            implementation(compose.material3)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.appcompat)
            implementation(libs.material)
            implementation(libs.androidx.lifecycle.runtime.ktx)
            implementation(libs.androidx.activity.compose)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.coil.compose)
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}

android {
    namespace = "io.github.rocxteady.sheets.sample"

    compileSdk = rootProject.extra["compile_sdk"] as Int

    defaultConfig {
        applicationId = "io.github.rocxteady.sheets.sample"
        minSdk = 21
        targetSdk = rootProject.extra["target_sdk"] as Int
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

compose.desktop {
    application {
        mainClass = "io.github.rocxteady.sheets.sample.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.github.rocxteady.sheets.sample"
            packageVersion = "1.0.0"
        }
    }
}
