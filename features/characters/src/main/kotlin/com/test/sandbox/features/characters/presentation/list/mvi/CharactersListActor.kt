package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.mvi.Actor
import com.test.sandbox.libraries.characters.LoadCharactersUseCase
import com.test.sandbox.libraries.characters.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class CharactersListActor @Inject constructor(
    private val loadCharactersUseCase: LoadCharactersUseCase,
) : Actor<CharactersListAction, CharactersListEffect> {

    private var page = 0

    override fun invoke(action: CharactersListAction): Flow<CharactersListEffect> {
        return when (action) {
            CharactersListAction.LoadCharacters -> loadCharactersUseCase.loadCharacters(page++)
                .map<List<Character>, CharactersListEffect> { CharactersListEffect.CharactersData(it) }
                .catch {
                    page--
                    emit(CharactersListEffect.Error(it))
                }
                .onStart { emit(CharactersListEffect.Loading) }
            is CharactersListAction.OpenDetails -> {
                flowOf(CharactersListEffect.OpenDetails(action.character))
            }
        }
            .catch { emit(CharactersListEffect.Error(it)) }
            .flowOn(Dispatchers.IO)
    }
}
