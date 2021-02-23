package com.test.sandbox.common.di

internal interface IComponentInjector<Component, Dependency> {

    fun getComponent(dependency: Dependency): Component

    fun clearComponent()
}
