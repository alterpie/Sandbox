package com.test.sandbox

import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementation(vararg deps: Any) {
    deps.forEach { dep ->
        add("implementation", dep)
    }
}

fun DependencyHandlerScope.testImplementation(vararg deps: Any) {
    deps.forEach { dep ->
        add("testImplementation", dep)
    }
}

fun DependencyHandlerScope.androidTestImplementation(vararg deps: Any) {
    deps.forEach { dep ->
        add("androidTestImplementation", dep)
    }
}

fun DependencyHandlerScope.kapt(vararg deps: Any) {
    deps.forEach { dep ->
        add("kapt", dep)
    }
}

fun DependencyHandlerScope.compileOnly(vararg deps: Any) {
    deps.forEach { dep ->
        add("compileOnly", dep)
    }
}

fun DependencyHandlerScope.api(vararg deps: Any) {
    deps.forEach { dep ->
        add("api", dep)
    }
}

fun DependencyHandlerScope.lintChecks(vararg deps: Any) {
    deps.forEach { dep ->
        add("lintChecks", dep)
    }
}

fun DependencyHandlerScope.testRuntimeOnly(vararg deps: Any) {
    deps.forEach { dep ->
        add("testRuntimeOnly", dep)
    }
}
