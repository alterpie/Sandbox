package com.test.transferwise.core.characters

import com.test.transferwise.core.characters.model.Character

interface CharactersRepository {

    suspend fun getCharacters(page: Int): List<Character>
}
