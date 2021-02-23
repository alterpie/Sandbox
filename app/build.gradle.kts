
import com.test.sandbox.Deps
import com.test.sandbox.implementation
import com.test.sandbox.testImplementation

plugins {
    id("android-configuration-plugin")
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
