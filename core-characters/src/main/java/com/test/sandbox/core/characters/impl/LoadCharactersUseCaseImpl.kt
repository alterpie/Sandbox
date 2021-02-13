package com.test.sandbox.core.characters.impl

import com.test.sandbox.core.characters.CharactersRepository
import com.test.sandbox.core.characters.LoadCharactersUseCase
import com.test.sandbox.core.characters.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.time.Duration
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class LoadCharactersUseCaseImpl @Inject constructor(
    private val charactersRepository: CharactersRepository,
) : LoadCharactersUseCase {

    companion object {
        private val CACHE_VALID_THRESHOLD = TimeUnit.MINUTES.toSeconds(2L)
    }

    private var loadTimestamp = ZonedDateTime.now().minusDays(1)

    override fun loadCharacters(page: Int): Flow<List<Character>> {
        return flow {
            val charactersLocal = charactersRepository.getCharacters(page)
            if (charactersLocal.isNotEmpty()) {
                emit(charactersLocal)
            }
            if (!isCacheValid()) {
                val charactersRemote = charactersRepository.fetchCharacters(page)
                emit(charactersRemote)
                loadTimestamp = ZonedDateTime.now()
                charactersRepository.persistCharacters(charactersRemote)
            }
        }
    }

    override fun loadCharacter(id: Long): Flow<Character> {
        return flow {
            emit(charactersRepository.getCharacter(id))
            if (!isCacheValid()) {
                val character = charactersRepository.fetchCharacter(id)
                emit(character)
                charactersRepository.persistCharacter(character)
            }
        }
            .flowOn(Dispatchers.IO)
    }

    private fun isCacheValid(): Boolean {
        return Duration.between(loadTimestamp, ZonedDateTime.now()).seconds < CACHE_VALID_THRESHOLD
    }
}
