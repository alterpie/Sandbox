package com.test.sandbox.core.characters.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.sandbox.core.characters.storage.model.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
internal abstract class CharactersDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}
