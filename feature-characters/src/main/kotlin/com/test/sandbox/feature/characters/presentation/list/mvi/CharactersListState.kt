package com.test.sandbox.feature.characters.presentation.list.mvi

import com.test.sandbox.core.characters.model.Character

internal data class CharactersListState(
    val characters: List<Character>,
    val isLoading: Boolean,
) {

    companion object {
        val INITIAL = CharactersListState(emptyList(), false)
    }
}
