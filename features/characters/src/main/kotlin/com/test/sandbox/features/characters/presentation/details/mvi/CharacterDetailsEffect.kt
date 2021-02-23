package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.sandbox.libraries.characters.model.Character

internal sealed class CharacterDetailsEffect {
    data class Data(val character: Character) : CharacterDetailsEffect()
    data class Error(val throwable: Throwable) : CharacterDetailsEffect()
}
