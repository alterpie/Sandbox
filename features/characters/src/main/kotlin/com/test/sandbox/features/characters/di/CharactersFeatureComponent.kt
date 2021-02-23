package com.test.sandbox.features.characters.di

import com.test.sandbox.common.di.FeatureScope
import com.test.sandbox.features.characters.presentation.details.di.CharacterDetailsSubcomponent
import com.test.sandbox.features.characters.presentation.list.CharacterListFragment
import com.test.sandbox.libraries.characters.di.CharactersLibraryComponent
import dagger.Component
import dagger.Module

@FeatureScope
@Component(
    dependencies = [CharactersLibraryComponent::class],
    modules = [CharactersFeatureModule::class]
)
interface CharactersFeatureComponent {

    val characterDetailsSubcomponent: CharacterDetailsSubcomponent.Factory

    fun inject(target: CharacterListFragment)

    @Component.Factory
    interface Factory {
        fun create(libraryComponent: CharactersLibraryComponent): CharactersFeatureComponent
    }
}

@Module(subcomponents = [CharacterDetailsSubcomponent::class])
private interface CharactersFeatureModule {

}
