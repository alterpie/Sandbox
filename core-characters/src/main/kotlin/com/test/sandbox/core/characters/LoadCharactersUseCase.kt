package com.test.sandbox.core.characters

import com.test.sandbox.core.characters.model.Character
import kotlinx.coroutines.flow.Flow

interface LoadCharactersUseCase {
    fun loadCharacters(page: Int): Flow<List<Character>>
    fun loadCharacter(id: Long): Flow<Character>
}
