package com.test.sandbox.libraries.characters.di

import android.content.Context
import androidx.room.Room
import com.test.sandbox.common.di.LibraryScope
import com.test.sandbox.libraries.characters.CharactersRepository
import com.test.sandbox.libraries.characters.LoadCharactersUseCase
import com.test.sandbox.libraries.characters.impl.CharactersRepositoryImpl
import com.test.sandbox.libraries.characters.impl.LoadCharactersUseCaseImpl
import com.test.sandbox.libraries.characters.storage.CharactersDao
import com.test.sandbox.libraries.characters.storage.CharactersDatabase
import com.test.sandbox.network.api.characters.CharactersApi
import dagger.*

@LibraryScope
@Component(
    modules = [
        CharactersLibraryModule::class,
        CharactersStorageModule::class,
    ]
)
interface CharactersLibraryComponent {

    val loadCharactersUseCase: LoadCharactersUseCase

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance charactersApi: CharactersApi
        ): CharactersLibraryComponent
    }
}

@Module
private interface CharactersLibraryModule {

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
