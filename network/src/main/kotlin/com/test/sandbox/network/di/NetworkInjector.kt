package com.test.sandbox.network.di

import com.test.sandbox.common.di.ComponentInjector

object NetworkInjector : ComponentInjector<NetworkComponent, Unit>() {

    override fun createComponent(dependency: Unit): NetworkComponent {
        return DaggerNetworkComponent.factory().create()
    }
}
