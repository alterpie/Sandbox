package com.test.sandbox.libraries.characters.impl

import com.test.sandbox.libraries.characters.CharactersRepository
import com.test.sandbox.libraries.characters.mapper.CharacterDtoMapper
import com.test.sandbox.libraries.characters.mapper.CharacterEntityMapper
import com.test.sandbox.libraries.characters.mapper.CharacterMapper
import com.test.sandbox.libraries.characters.model.Character
import com.test.sandbox.libraries.characters.storage.CharactersDao
import com.test.sandbox.network.api.characters.CharactersApi
import javax.inject.Inject

internal class CharactersRepositoryImpl @Inject constructor(
    private val charactersApi: CharactersApi,
    private val charactersDao: CharactersDao,
) : CharactersRepository {

    override suspend fun fetchCharacters(page: Int): List<Character> {
        return charactersApi.getCharacters(page).results.map(CharacterDtoMapper::invoke)
    }

    override suspend fun getCharacters(page: Int): List<Character> {
        return charactersDao.getAll().map(CharacterEntityMapper::invoke)
    }

    override suspend fun persistCharacters(characters: List<Character>) {
        charactersDao.insert(characters.map(CharacterMapper::invoke))
    }

    override suspend fun persistCharacter(character: Character) {
        charactersDao.insert(character.let(CharacterMapper::invoke))
    }

    override suspend fun getCharacter(id: Long): Character {
        return charactersDao.getById(id).let(CharacterEntityMapper::invoke)
    }

    override suspend fun fetchCharacter(id: Long): Character {
        return charactersApi.getCharacter(id).let(CharacterDtoMapper::invoke)
    }

}
