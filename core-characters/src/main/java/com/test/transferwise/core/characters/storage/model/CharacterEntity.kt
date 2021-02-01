package com.test.transferwise.core.characters.storage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
internal data class CharacterEntity(
    @ColumnInfo(name = "characterId")
    @PrimaryKey
    val id: Long,
    val name: String,
    val species: String,
    val gender: String,
    val image: String,
    val status: String,
//    val episodes: List<String>,
)
