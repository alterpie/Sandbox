package com.test.transferwise.core.characters.impl

import com.test.transferwise.core.characters.CharactersRepository
import com.test.transferwise.core.characters.mapper.CharacterMapper
import com.test.transferwise.core.characters.model.Character
import com.test.transferwise.network.api.characters.CharactersApi
import javax.inject.Inject

internal class CharactersRepositoryImpl @Inject constructor(
    private val charactersApi: CharactersApi
) : CharactersRepository {

    override suspend fun getCharacters(page: Int): List<Character> {
        return charactersApi.getCharacters(page).results.map(CharacterMapper::map)
    }
}
