import com.test.sandbox.Deps
import com.test.sandbox.implementation
import com.test.sandbox.kapt

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Deps.BuildVersions.compileSdk)

    defaultConfig {
        minSdkVersion(Deps.BuildVersions.minSdk)
        targetSdkVersion(Deps.BuildVersions.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = Deps.UiTest.testIntrumentationRunner
    }

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