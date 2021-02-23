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
    ":features:characters",
    ":libraries:characters",
    ":network",
    ":common",
    ":mvi"
)
