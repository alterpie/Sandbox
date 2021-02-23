package com.test.sandbox

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaBasePlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidConfigurationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(plugins) {
                if (target.name == "app") {
                    apply("com.android.application")
                } else {
                    apply("com.android.library")
                }
                apply("kotlin-android")
                apply("kotlin-kapt")
            }

            configureAndroid()
            configureKotlin()
            configureJava()
        }
    }

    private fun Project.configureAndroid() {
        configureAppModule()
        configureLibraryModule()

        dependencies.add("coreLibraryDesugaring", Deps.Android.coreLibraryDesugaring)

        extensions.getByType(CommonExtension::class).buildFeatures.viewBinding = true
    }

    private fun Project.configureAppModule() {
        plugins.withType<AppPlugin> {
            extensions.getByType<BaseAppModuleExtension>().apply {
                configureBaseExtension()
                defaultConfig {
                    applicationId = "com.test.sandbox"
                    targetSdkVersion(Deps.BuildVersions.targetSdk)
                    versionCode = 1
                    versionName = "1.0"
                }

                buildTypes {
                    val debug = AppBuildType.Debug
                    getByName(debug.name) {
                        isMinifyEnabled = debug.isMinifiedEnabled
                    }

                    val release = AppBuildType.Release
                    getByName(release.name) {
                        isMinifyEnabled = release.isMinifiedEnabled
                        proguardFiles.add(
                            getDefaultProguardFile("proguard-android-optimize.txt")
                        )
                    }
                }
            }
        }
    }

    private fun Project.configureLibraryModule(){
        plugins.withType<LibraryPlugin> {
            extensions.getByType<LibraryExtension>().apply {
                configureBaseExtension()

                buildTypes {
                    val debug = AppBuildType.Debug
                    getByName(debug.name) {
                        isMinifyEnabled = debug.isMinifiedEnabled
                    }
                }
//                variantFilter {
//                    ignore = buildType.name != "release"
//                }
            }
        }
    }

    private fun BaseExtension.configureBaseExtension() {
        compileSdkVersion(Deps.BuildVersions.compileSdk)

        defaultConfig {
            minSdkVersion(Deps.BuildVersions.minSdk)

            testInstrumentationRunner = Deps.UiTest.testIntrumentationRunner
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
            isCoreLibraryDesugaringEnabled = true
        }

        lintOptions {

        }

        sourceSets.forEach {
            it.java.srcDirs("src/${it.name}/kotlin")
        }
    }

    private fun Project.configureKotlin() {
        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }

    private fun Project.configureJava() {
        plugins.withType<JavaBasePlugin> {
            extensions.getByType<JavaPluginExtension>().apply {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
    }
}
