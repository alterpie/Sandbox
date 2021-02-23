package com.test.sandbox

object Deps {
    object Android {
        private const val pluginVersion = "7.0.0-alpha07"
        private const val coreLibraryDesugaringVersion = "1.1.1"

        const val plugin = "com.android.tools.build:gradle:$pluginVersion"
        const val coreLibraryDesugaring =
            "com.android.tools:desugar_jdk_libs:$coreLibraryDesugaringVersion"
    }

    object BuildVersions {
        const val minSdk = 21
        const val targetSdk = 30
        const val compileSdk = 30
    }

    object Kotlin {
        private const val kotlinVersion = "1.4.30"
        private const val coroutinesVersion = "1.4.2"
        private const val serializationVersion = "1.0.1"

        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$version"
        const val moshiAdapter = "com.squareup.retrofit2:converter-moshi:$version"

    }

    object UI {
        private const val recyclerViewVersion = "1.1.0"
        private const val constraintLayoutVersion = "2.0.4"
        private const val coreVersion = "1.5.0-beta01"
        private const val materialVersion = "1.3.0"

        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
        const val material = "com.google.android.material:material:$materialVersion"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val core = "androidx.core:core-ktx:$coreVersion"
    }

    object Jetpack {
        object Navigation {
            private const val navigationVersion = "2.3.3"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        }

        object Lifecycle {
            private const val lifecycleVersion = "2.3.0"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
            const val common = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        }

        object Room {
            private const val roomVersion = "2.2.6"
            const val core = "androidx.room:room-runtime:$roomVersion"
            const val compiler = "androidx.room:room-compiler:$roomVersion"
            const val ktx = "androidx.room:room-ktx:$roomVersion"
        }
    }

    object Dagger {
        private const val daggerVersion = "2.31.2"

        const val compiler = "com.google.dagger:dagger-compiler:$daggerVersion"
        const val core = "com.google.dagger:dagger:$daggerVersion"
    }

    object Coil {
        private const val coilVersion = "1.1.1"
        const val coil = "io.coil-kt:coil:$coilVersion"
    }

    object Moshi {
        private const val moshiVersion = "1.11.0"
        const val core = "com.squareup.moshi:moshi:$moshiVersion"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
    }

    object OkHttp {
        private const val okhttpVersion = "3.12.1"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
    }

    object UnitTest {
        private const val jUnitVersion = "4.13.1"
        const val jUnit = "junit:junit:$jUnitVersion"
    }

    object UiTest {
        private const val testRunnerVersion = "1.0.0"
        const val testRunner = "androidx.test:runner:$testRunnerVersion"
        const val testIntrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
