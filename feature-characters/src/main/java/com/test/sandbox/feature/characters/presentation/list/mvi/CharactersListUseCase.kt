package com.test.sandbox.feature.characters.presentation.list.mvi

import com.test.mvi.UseCase
import com.test.sandbox.core.characters.LoadCharactersUseCase
import com.test.sandbox.core.characters.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class CharactersListUseCase @Inject constructor(
    private val loadCharactersUseCase: LoadCharactersUseCase,
) : UseCase<CharactersListAction, CharactersListEffect> {

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
        }
            .catch { emit(CharactersListEffect.Error(it)) }
            .flowOn(Dispatchers.IO)
    }
}
