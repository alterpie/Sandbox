package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.sandbox.libraries.characters.model.Character

internal data class CharactersListState(
    val characters: List<Character>,
    val isLoading: Boolean,
) {

    companion object {
        val INITIAL = CharactersListState(emptyList(), true)
    }
}
