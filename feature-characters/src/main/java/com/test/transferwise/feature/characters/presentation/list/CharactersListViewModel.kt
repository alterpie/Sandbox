package com.test.transferwise.feature.characters.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.transferwise.core.characters.CharactersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CharactersListViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersListState(emptyList()))
    val state: StateFlow<CharactersListState> = _state

    init {
        viewModelScope.launch {
            val characters = charactersRepository.getCharacters(1)
            _state.value = CharactersListState(characters)
        }
    }
}
