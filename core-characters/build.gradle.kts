import com.test.sandbox.Deps
import com.test.sandbox.implementation
import com.test.sandbox.kapt
import com.test.sandbox.testImplementation

plugins {
    id("android-configuration-plugin")

}

android {
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles.addAll(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    file("proguard-rules.pro")
                )
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.1")

    implementation(
        project(":common"),
        project(":network"),

        Deps.Dagger.core,

        Deps.Jetpack.Room.core,
        Deps.Jetpack.Room.ktx
    )

    testImplementation(Deps.UnitTest.jUnit)

    kapt(
        Deps.Dagger.compiler,
        Deps.Jetpack.Room.compiler
    )
}