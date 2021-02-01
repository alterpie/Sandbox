package com.test.transferwise.core.characters.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.transferwise.core.characters.storage.model.CharacterEntity

@Dao
internal interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characters: List<CharacterEntity>)

    @Query("SELECT * FROM characters")
    fun getAll(): List<CharacterEntity>

    @Query("SELECT * FROM characters WHERE characterId=:id")
    fun getById(id: Long): CharacterEntity
}
