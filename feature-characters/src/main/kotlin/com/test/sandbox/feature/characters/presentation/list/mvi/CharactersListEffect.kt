package com.test.sandbox.feature.characters.presentation.list.mvi

import com.test.sandbox.core.characters.model.Character

internal sealed class CharactersListEffect {
    data class Error(val throwable: Throwable) : CharactersListEffect()
    data class CharactersData(val characters: List<Character>) : CharactersListEffect()
    object Loading : CharactersListEffect()
}
