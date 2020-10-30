pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
        maven("https://nexus.inductiveautomation.com/repository/public")
    }
}

rootProject.name = "kotlin-example"

include(
    ":",
    ":common",
    ":gateway",
    ":designer"
)
