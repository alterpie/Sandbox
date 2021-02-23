package com.test.sandbox.features.characters.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.sandbox.libraries.characters.LoadCharactersUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class CharacterDetailsViewModel @AssistedInject constructor(
    @Assisted private val characterId: Long,
    private val useCase: LoadCharactersUseCase
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(characterId: Long): CharacterDetailsViewModel
    }

    private val _state = MutableStateFlow(CharacterDetailsState(null))
    val state: StateFlow<CharacterDetailsState> = _state

    init {
        useCase.loadCharacter(characterId)
            .onEach { _state.value = CharacterDetailsState(it) }
            .launchIn(viewModelScope)
    }
}
