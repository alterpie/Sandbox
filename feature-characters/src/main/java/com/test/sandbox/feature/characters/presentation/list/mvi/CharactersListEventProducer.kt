package com.test.sandbox.feature.characters.presentation.list.mvi

import com.test.mvi.EventProducer

internal object CharactersListEventProducer :
    EventProducer<CharactersListEffect, CharactersListEvent> {

    override fun invoke(effect: CharactersListEffect): CharactersListEvent? {
        return when (effect) {
            is CharactersListEffect.Error -> CharactersListEvent.Error(effect.throwable)
            else -> null
        }
    }
}
