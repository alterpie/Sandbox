import com.test.sandbox.Deps

plugins {
    id("java-configuration-plugin")
}

dependencies {
    implementation(
        Deps.Kotlin.coroutines
    )
}
