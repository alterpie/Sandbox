package com.test.transferwise.core.characters

import com.test.transferwise.core.characters.model.Character

internal interface CharactersRepository {
    suspend fun fetchCharacters(page: Int): List<Character>
    suspend fun getCharacters(page: Int): List<Character>
    suspend fun persistCharacters(characters: List<Character>)
    suspend fun getCharacter(id: Long): Character
}
