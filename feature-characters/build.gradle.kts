import com.test.sandbox.Deps
import com.test.sandbox.implementation

plugins {
    id("android-configuration-plugin")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {

    implementation(
        project(":common"),
        project(":core-ui"),
        project(":core-characters"),
        project(":mvi"),

        Deps.UI.core,
        Deps.UI.constraintLayout,
        Deps.UI.material,
        Deps.UI.recyclerView,
        Deps.Jetpack.Navigation.fragment,

        Deps.Coil.coil,

        Deps.Jetpack.Lifecycle.viewModel,
        Deps.Jetpack.Lifecycle.common,

        Deps.Kotlin.coroutines,

        Deps.Dagger.core
    )

    testImplementation(Deps.UnitTest.jUnit)

    kapt(Deps.Dagger.compiler)
}
