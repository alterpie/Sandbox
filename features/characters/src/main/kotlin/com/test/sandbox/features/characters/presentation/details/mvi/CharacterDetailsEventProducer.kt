package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.mvi.Event
import com.test.mvi.EventProducer
import com.test.sandbox.core.ui.ErrorEvent
import com.test.sandbox.core.ui.NavigateUp

internal object CharacterDetailsEventProducer : EventProducer<CharacterDetailsEffect> {
    override fun invoke(effect: CharacterDetailsEffect): Event? {
        return when (effect) {
            is CharacterDetailsEffect.Error -> ErrorEvent.Short(effect.throwable)
            CharacterDetailsEffect.NavigateBack -> NavigateUp
            else -> null
        }
    }
}
