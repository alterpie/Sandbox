package com.test.mvi

interface Reducer<State : Any, Effect : Any> : (State, Effect) -> State {
    override fun invoke(previousState: State, effect: Effect): State
}
