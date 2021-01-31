package com.test.transferwise.core.characters.di

import com.test.transferwise.common.ComponentInjector
import com.test.transferwise.network.di.NetworkInjector

object CharactersCoreInjector :ComponentInjector<CharactersCoreComponent, Unit>(){

    override fun createComponent(dependency: Unit): CharactersCoreComponent {
        return DaggerCharactersCoreComponent.factory()
            .create(NetworkInjector.getComponent(Unit).charactersApi)
    }
}
