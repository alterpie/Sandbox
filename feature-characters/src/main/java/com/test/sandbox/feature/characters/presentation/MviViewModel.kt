package com.test.sandbox.feature.characters.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.mvi.Store
import kotlinx.coroutines.flow.*

abstract class MviViewModel<State : Any, Action : Any>(
    private val store: Store<State, *, Action>
) : ViewModel() {

    private val _state = MutableStateFlow(store.initialState)
    val state: Flow<State> = _state

    private val _events = MutableSharedFlow<Any>(extraBufferCapacity = 42)
    val events: Flow<Any> = _events

    init {
        store.collectState()
            .onEach(::updateState)
            .launchIn(viewModelScope)

        store.collectEvents()
            .onEach(::sendEvent)
            .launchIn(viewModelScope)
    }

    private fun updateState(state: State) {
        _state.value = state
    }

    private fun sendEvent(event: Any) {
        _events.tryEmit(event)
    }

    fun acceptAction(action: Action) {
        store.acceptAction(action)
    }
}
