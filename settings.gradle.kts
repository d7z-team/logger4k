rootProject.name = "logger4k"
include("logger-core", "logger-console", "logger-forward")

pluginManagement {
    val ktLintVersion = "10.1.0"
    plugins {
        id("org.jlleitschuh.gradle.ktlint") version ktLintVersion
        id("org.jlleitschuh.gradle.ktlint-idea") version ktLintVersion
    }
}
