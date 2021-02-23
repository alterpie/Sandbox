package com.test.sandbox.features.characters.presentation.details.di

import com.test.sandbox.features.characters.presentation.details.CharacterDetailsFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface CharacterDetailsSubcomponent {

    fun inject(target: CharacterDetailsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance characterId: Long): CharacterDetailsSubcomponent
    }
}
