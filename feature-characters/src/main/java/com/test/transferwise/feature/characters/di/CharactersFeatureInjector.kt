package com.test.transferwise.feature.characters.di

import com.test.transferwise.common.ComponentInjector
import com.test.transferwise.core.characters.di.CharactersCoreInjector

object CharactersFeatureInjector : ComponentInjector<CharactersFeatureComponent, Unit>() {
    override fun createComponent(dependency: Unit): CharactersFeatureComponent {
        return DaggerCharactersFeatureComponent.factory()
            .create(CharactersCoreInjector.getComponent(Unit))
    }
}
