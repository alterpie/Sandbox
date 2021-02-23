package com.test.sandbox.feature.characters.di

import com.test.sandbox.common.di.FeatureScope
import com.test.sandbox.core.characters.di.CharactersCoreComponent
import com.test.sandbox.feature.characters.presentation.details.CharacterDetailsFragment
import com.test.sandbox.feature.characters.presentation.list.CharacterListFragment
import dagger.Component

@FeatureScope
@Component(dependencies = [CharactersCoreComponent::class])
interface CharactersFeatureComponent {

    fun inject(target: CharacterListFragment)
    fun inject(target: CharacterDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CharactersCoreComponent): CharactersFeatureComponent
    }
}
