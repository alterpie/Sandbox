package com.test.mvi

interface Reducer<Effect : Any, State : Any> : (State, Effect) -> State {
    override fun invoke(previousState: State, effect: Effect): State
}
