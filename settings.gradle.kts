pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

includeBuild("plugins/dependencies")
includeBuild("plugins/configurations")

include(
    ":app",
    ":core-ui",
    ":feature-characters",
    ":core-characters",
    ":network",
    ":common",
    ":mvi"
)
