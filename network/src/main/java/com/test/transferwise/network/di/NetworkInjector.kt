package com.test.transferwise.network.di

import com.test.transferwise.common.ComponentInjector

object NetworkInjector : ComponentInjector<NetworkComponent, Unit>() {

    override fun createComponent(dependency: Unit): NetworkComponent {
        return DaggerNetworkComponent.factory().create()
    }
}
