package com.test.mvi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class Store<State : Any, Effect : Any, Action : Any>(
    val initialState: State,
    private val actor: Actor<Action, Effect>,
    private val reducer: Reducer<State, Effect>,
    private val eventProducer: EventProducer<Effect, *>? = null,
) {

    private val stateFlow = MutableStateFlow(initialState)
    private val actionFlow = MutableSharedFlow<Action>(extraBufferCapacity = 42)
    private val eventFlow = MutableSharedFlow<Any>(extraBufferCapacity = 42)

    private val reducerMutex = Mutex()

    fun collectState(): Flow<State> {
        return actionFlow
            .flatMapConcat(actor::invoke)
            .onEach { effect ->
                val event = eventProducer?.invoke(effect)
                event?.let(eventFlow::tryEmit)
            }
            .map { effect ->
                reducerMutex.withLock {
                    val newState = reducer(stateFlow.value, effect)
                    stateFlow.emit(newState)
                    newState
                }
            }
            .distinctUntilChanged()
            .flowOn(Dispatchers.IO)
            .onStart { emit(initialState) }
            .flowOn(Dispatchers.Main)
    }

    fun acceptAction(action: Action) {
        actionFlow.tryEmit(action)
    }

    fun collectEvents(): Flow<Any> {
        return eventFlow
    }
}
