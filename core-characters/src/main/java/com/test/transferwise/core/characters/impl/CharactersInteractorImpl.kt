package com.test.transferwise.core.characters.impl

import com.test.transferwise.core.characters.CharactersInteractor
import com.test.transferwise.core.characters.CharactersRepository
import com.test.transferwise.core.characters.model.Character
import javax.inject.Inject

internal class CharactersInteractorImpl @Inject constructor(
    private val charactersRepository: CharactersRepository
) : CharactersInteractor {

    override suspend fun loadCharacters(page: Int): List<Character> {
        val charactersPersisted = charactersRepository.getCharacters(page)
        return if (charactersPersisted.isEmpty()) {
            charactersRepository.fetchCharacters(page)
                .also { charactersRepository.persistCharacters(it) }
        } else {
            charactersPersisted
        }
    }

    override suspend fun loadCharacter(id: Long): Character {
        return charactersRepository.getCharacter(id)
    }
}
