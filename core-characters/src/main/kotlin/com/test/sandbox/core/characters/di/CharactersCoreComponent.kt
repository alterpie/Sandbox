package com.test.sandbox.core.characters.di

import android.content.Context
import androidx.room.Room
import com.test.sandbox.common.di.LibraryScope
import com.test.sandbox.core.characters.CharactersRepository
import com.test.sandbox.core.characters.LoadCharactersUseCase
import com.test.sandbox.core.characters.impl.CharactersRepositoryImpl
import com.test.sandbox.core.characters.impl.LoadCharactersUseCaseImpl
import com.test.sandbox.core.characters.storage.CharactersDao
import com.test.sandbox.core.characters.storage.CharactersDatabase
import com.test.sandbox.network.api.characters.CharactersApi
import dagger.*

@LibraryScope
@Component(
    modules = [
        CharactersCoreModule::class,
        CharactersStorageModule::class,
    ]
)
interface CharactersCoreComponent {

    val loadCharactersUseCase: LoadCharactersUseCase

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
    @LibraryScope
    fun charactersRepository(impl: CharactersRepositoryImpl): CharactersRepository

    @Binds
    @LibraryScope
    fun loadCharactersUseCase(impl: LoadCharactersUseCaseImpl): LoadCharactersUseCase
}

@Module
private object CharactersStorageModule {

    @Provides
    @LibraryScope
    fun charactersDatabase(context: Context): CharactersDatabase {
        return Room.databaseBuilder(context, CharactersDatabase::class.java, "characters_db")
            .build()
    }

    @Provides
    @LibraryScope
    fun charactersDao(db: CharactersDatabase): CharactersDao {
        return db.charactersDao()
    }
}
