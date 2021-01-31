package com.test.transferwise.feature.characters.di

import com.test.transferwise.core.characters.di.CharactersCoreComponent
import com.test.transferwise.feature.characters.presentation.list.CharacterListFragment
import dagger.Component
import javax.inject.Singleton

@CharacterFeatureScope
@Component(dependencies = [CharactersCoreComponent::class])
interface CharactersFeatureComponent {

    fun inject(target: CharacterListFragment)
//    fun inject(target: CharacterDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CharactersCoreComponent): CharactersFeatureComponent
    }
}
