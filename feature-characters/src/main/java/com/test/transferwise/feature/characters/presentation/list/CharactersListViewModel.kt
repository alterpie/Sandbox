package com.test.transferwise.feature.characters.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.transferwise.core.characters.CharactersInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharactersListViewModel @Inject constructor(
    private val charactersInteractor: CharactersInteractor
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersListState(emptyList()))
    val state: StateFlow<CharactersListState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val characters = charactersInteractor.loadCharacters(1)
            _state.value = CharactersListState(characters)
        }
    }
}
