package com.test.mvi

import kotlinx.coroutines.flow.Flow

interface Actor<Action : Any, Effect : Any> : (Action) -> Flow<Effect> {
    override fun invoke(action: Action): Flow<Effect>
}
