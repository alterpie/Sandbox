import com.test.sandbox.Deps
import com.test.sandbox.implementation
import com.test.sandbox.testImplementation

plugins {
    id("android-configuration-plugin")
}

android {
    defaultConfig {
        applicationId = "com.test.sandbox"

        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(
        project(":features:characters"),

        Deps.UI.material,
        Deps.UI.core,
        Deps.UI.constraintLayout,
        Deps.Jetpack.Navigation.fragment
    )

    testImplementation(Deps.UnitTest.jUnit)
}
