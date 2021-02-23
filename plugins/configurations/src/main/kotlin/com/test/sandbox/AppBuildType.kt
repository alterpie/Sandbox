package com.test.sandbox

sealed class AppBuildType(
    val name: String,
    val isMinifiedEnabled: Boolean
) {
    object Debug : AppBuildType("debug", false)
    object Release : AppBuildType("release", true)
}
