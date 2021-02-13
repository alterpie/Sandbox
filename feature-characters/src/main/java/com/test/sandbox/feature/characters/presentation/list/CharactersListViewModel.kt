package com.test.sandbox.feature.characters.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.sandbox.feature.characters.presentation.list.mvi.CharactersListAction
import com.test.sandbox.feature.characters.presentation.list.mvi.CharactersListState
import com.test.sandbox.feature.characters.presentation.list.mvi.CharactersListStore
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class CharactersListViewModel @Inject constructor(
    private val store: CharactersListStore
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersListState.INITIAL)
    val state: Flow<CharactersListState> = _state

    private val _events = MutableSharedFlow<Any>(extraBufferCapacity = 42)
    val events: Flow<Any> = _events

    init {
        store.collectState()
            .onEach { _state.value = it }
            .launchIn(viewModelScope)

        store.collectEvents()
            .onEach(_events::emit)
            .launchIn(viewModelScope)

        store.acceptAction(CharactersListAction.LoadCharacters)
    }

    fun acceptAction(action: CharactersListAction) {
        store.acceptAction(action)
    }
}
