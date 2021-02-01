package com.test.transferwise.core.characters

import com.test.transferwise.core.characters.model.Character

interface CharactersInteractor {

    suspend fun loadCharacters(page: Int): List<Character>

    suspend fun loadCharacter(id: Long): Character
}
