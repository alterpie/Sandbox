package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.mvi.Actor
import com.test.sandbox.libraries.characters.LoadCharactersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class CharacterDetailsActor @Inject constructor(
    private val characterId: Long,
    private val loadCharactersUseCase: LoadCharactersUseCase,
) : Actor<CharacterDetailsAction, CharacterDetailsEffect> {
    override fun invoke(action: CharacterDetailsAction): Flow<CharacterDetailsEffect> {
        return when (action) {
            CharacterDetailsAction.LoadCharacter -> loadCharacterEffect()
            CharacterDetailsAction.NavigateBack -> flowOf(CharacterDetailsEffect.NavigateBack)
        }
            .catch { emit(CharacterDetailsEffect.Error(it)) }
    }

    private fun loadCharacterEffect(): Flow<CharacterDetailsEffect> {
        return loadCharactersUseCase.loadCharacter(characterId)
            .map { CharacterDetailsEffect.Data(it) }
    }
}
