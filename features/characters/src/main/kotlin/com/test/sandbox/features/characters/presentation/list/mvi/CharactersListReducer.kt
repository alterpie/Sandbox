package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.mvi.Reducer

internal object CharactersListReducer : Reducer<CharactersListEffect, CharactersListState> {

    override fun invoke(
        previousState: CharactersListState,
        effect: CharactersListEffect
    ): CharactersListState {
        return when (effect) {
            is CharactersListEffect.CharactersData -> {
                previousState.copy(characters = effect.characters, isLoading = false)
            }
            CharactersListEffect.Loading -> {
                previousState.copy(isLoading = true)
            }
            is CharactersListEffect.Error -> previousState.copy(isLoading = false)
            else -> previousState
        }
    }
}
