package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.mvi.EventProducer

internal object CharacterDetailsEventProducer :
    EventProducer<CharacterDetailsEffect, CharacterDetailsEvent> {
    override fun invoke(effect: CharacterDetailsEffect): CharacterDetailsEvent? {
        return when (effect) {
            is CharacterDetailsEffect.Error -> CharacterDetailsEvent.Error(effect.throwable)
            else -> null
        }
    }
}
