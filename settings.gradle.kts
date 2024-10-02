rootProject.name = "sheets"

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenLocal()
    }
}

include (":sample")
include (":sheets-core")
include (":sheets")
include (":sheets-m3")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")
}