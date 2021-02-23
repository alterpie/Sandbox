import com.test.sandbox.Deps

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    id("dependencies")
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(Deps.Android.plugin)
    implementation(Deps.Kotlin.plugin)
}

kotlin.sourceSets.getByName("main").kotlin.srcDir("../dependencies/src/main/kotlin")

gradlePlugin {
    plugins.register("android-configuration-plugin") {
        id = "android-configuration-plugin"
        implementationClass = "com.test.sandbox.AndroidConfigurationPlugin"
    }

    plugins.register("java-configuration-plugin") {
        id = "java-configuration-plugin"
        implementationClass = "com.test.sandbox.JavaConfigurationPlugin"
    }
}
