package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.sandbox.libraries.characters.model.Character

internal sealed class CharactersListEffect {
    data class Error(val throwable: Throwable) : CharactersListEffect()
    data class CharactersData(val characters: List<Character>) : CharactersListEffect()
    data class OpenDetails(val character: Character) : CharactersListEffect()
    object Loading : CharactersListEffect()
}
