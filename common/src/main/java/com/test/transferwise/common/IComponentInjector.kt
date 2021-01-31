package com.test.transferwise.common

internal interface IComponentInjector<Component, Dependency> {

    fun getComponent(dependency: Dependency): Component

    fun clearComponent()
}
