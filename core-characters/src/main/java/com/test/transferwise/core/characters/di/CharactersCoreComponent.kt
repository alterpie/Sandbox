package com.test.transferwise.core.characters.di

import com.test.transferwise.core.characters.CharactersRepository
import com.test.transferwise.core.characters.impl.CharactersRepositoryImpl
import com.test.transferwise.network.api.characters.CharactersApi
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@CharactersCoreScope
@Component(modules = [CharactersCoreModule::class])
interface CharactersCoreComponent {

    val charactersRepository: CharactersRepository

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance charactersApi: CharactersApi
        ): CharactersCoreComponent
    }
}

@Module
private interface CharactersCoreModule {

    @Binds
    fun charactersRepository(impl: CharactersRepositoryImpl): CharactersRepository
}
