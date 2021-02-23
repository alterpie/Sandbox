package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.sandbox.libraries.characters.model.Character

internal data class CharacterDetailsState(
    val character: Character?
) {
    companion object {
        val INITIAL = CharacterDetailsState(null)
    }
}
