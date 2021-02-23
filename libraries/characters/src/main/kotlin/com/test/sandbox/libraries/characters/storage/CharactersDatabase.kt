package com.test.sandbox.libraries.characters.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.sandbox.libraries.characters.storage.model.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
internal abstract class CharactersDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}
