package com.test.transferwise.network.di

// NetworkInjector is used to achieve scalability of access to NetworkComponent. For example if we
// need to access it from different modules to retrieve few different APIs, this way it always will
// be 1 instance of NetworkComponent to access.
object NetworkInjector {

    private var component: NetworkComponent? = null

    @Synchronized
    fun getComponent(): NetworkComponent {
        return component ?: DaggerNetworkComponent.factory().create().also { component = it }
    }
}
