package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.mvi.Event
import com.test.mvi.EventProducer
import com.test.sandbox.core.ui.ErrorEvent
import com.test.sandbox.core.ui.Navigate
import com.test.sandbox.features.characters.presentation.list.CharacterListFragmentDirections

internal object CharactersListEventProducer : EventProducer<CharactersListEffect> {

    override fun invoke(effect: CharactersListEffect): Event? {
        return when (effect) {
            is CharactersListEffect.Error -> ErrorEvent.Short(effect.throwable)
            is CharactersListEffect.OpenDetails -> {
                Navigate(CharacterListFragmentDirections.toCharacterDetails(effect.character.id))
            }
            else -> null
        }
    }
}
