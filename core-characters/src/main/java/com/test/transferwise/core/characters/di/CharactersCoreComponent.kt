package com.test.transferwise.core.characters.di

import android.content.Context
import androidx.room.Room
import com.test.transferwise.core.characters.CharactersInteractor
import com.test.transferwise.core.characters.CharactersRepository
import com.test.transferwise.core.characters.impl.CharactersInteractorImpl
import com.test.transferwise.core.characters.impl.CharactersRepositoryImpl
import com.test.transferwise.core.characters.storage.CharactersDao
import com.test.transferwise.core.characters.storage.CharactersDatabase
import com.test.transferwise.network.api.characters.CharactersApi
import dagger.*

@CharactersCoreScope
@Component(
    modules = [
        CharactersCoreModule::class,
        CharactersStorageModule::class,
    ]
)
interface CharactersCoreComponent {

    val charactersInteractor: CharactersInteractor

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance charactersApi: CharactersApi
        ): CharactersCoreComponent
    }
}

@Module
private interface CharactersCoreModule {

    @Binds
    @CharactersCoreScope
    fun charactersRepository(impl: CharactersRepositoryImpl): CharactersRepository

    @Binds
    @CharactersCoreScope
    fun charactersInteractior(impl: CharactersInteractorImpl): CharactersInteractor
}

@Module
private object CharactersStorageModule {

    @Provides
    @CharactersCoreScope
    fun charactersDatabase(context: Context): CharactersDatabase {
        return Room.databaseBuilder(context, CharactersDatabase::class.java, "characters_db")
            .build()
    }

    @Provides
    @CharactersCoreScope
    fun charactersDao(db: CharactersDatabase): CharactersDao {
        return db.charactersDao()
    }
}
