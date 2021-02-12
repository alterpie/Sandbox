package com.test.sandbox.common

internal interface IComponentInjector<Component, Dependency> {

    fun getComponent(dependency: Dependency): Component

    fun clearComponent()
}
