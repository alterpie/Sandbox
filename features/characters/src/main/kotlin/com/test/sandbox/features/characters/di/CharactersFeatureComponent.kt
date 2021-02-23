package com.test.sandbox.features.characters.di

import com.test.sandbox.common.di.FeatureScope
import com.test.sandbox.features.characters.presentation.details.CharacterDetailsFragment
import com.test.sandbox.features.characters.presentation.list.CharacterListFragment
import com.test.sandbox.libraries.characters.di.CharactersLibraryComponent
import dagger.Component

@FeatureScope
@Component(dependencies = [CharactersLibraryComponent::class])
interface CharactersFeatureComponent {

    fun inject(target: CharacterListFragment)
    fun inject(target: CharacterDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(libraryComponent: CharactersLibraryComponent): CharactersFeatureComponent
    }
}
