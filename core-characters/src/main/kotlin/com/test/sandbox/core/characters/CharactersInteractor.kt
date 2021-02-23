package com.test.sandbox.core.characters

import com.test.sandbox.core.characters.model.Character

interface CharactersInteractor {
    suspend fun loadCharacters(page: Int): List<Character>
    suspend fun loadCharacter(id: Long): Character
}
