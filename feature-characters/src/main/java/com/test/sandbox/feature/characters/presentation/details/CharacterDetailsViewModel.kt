package com.test.sandbox.feature.characters.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.sandbox.core.characters.CharactersInteractor
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class CharacterDetailsViewModel @AssistedInject constructor(
    @Assisted private val characterId: Long,
    private val charactersInteractor: CharactersInteractor
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(characterId: Long): CharacterDetailsViewModel
    }

    private val _state = MutableStateFlow(CharacterDetailsState(null))
    val state: StateFlow<CharacterDetailsState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = CharacterDetailsState(charactersInteractor.loadCharacter(characterId))
        }

    }
}
