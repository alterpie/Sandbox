package com.test.sandbox.core.characters

import com.test.sandbox.core.characters.model.Character

internal interface CharactersRepository {
    suspend fun fetchCharacters(page: Int): List<Character>
    suspend fun getCharacters(page: Int): List<Character>
    suspend fun persistCharacters(characters: List<Character>)
    suspend fun getCharacter(id: Long): Character
}
