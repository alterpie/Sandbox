import com.test.sandbox.Deps
import com.test.sandbox.implementation
import com.test.sandbox.kapt

plugins {
    id("android-configuration-plugin")
}

dependencies {
    implementation(
        project(":common"),

        Deps.Retrofit.core,
        Deps.Retrofit.moshiAdapter,
        Deps.Moshi.core,
        Deps.OkHttp.loggingInterceptor,
        Deps.Kotlin.coroutines,
        Deps.Dagger.core
    )

    kapt(
        Deps.Moshi.codegen,
        Deps.Dagger.compiler
    )
}
