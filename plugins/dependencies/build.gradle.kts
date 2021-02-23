plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

group = "com.test.sandbox.dependencies"
version = "SNAPSHOT"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins.register("dependencies") {
        id = "dependencies"
        implementationClass = "com.test.sandbox.DependenciesPlugin"
    }
}
