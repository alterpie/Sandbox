import com.test.sandbox.Deps
import com.test.sandbox.implementation

plugins {
    id("android-configuration-plugin")
}

dependencies {

    implementation(
        project(":mvi"),
        Deps.UI.core,
        Deps.UI.material,
        Deps.Jetpack.Navigation.fragment,
        Deps.Jetpack.Lifecycle.common
    )

    testImplementation(Deps.UnitTest.jUnit)
}
