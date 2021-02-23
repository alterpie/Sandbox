package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.mvi.Reducer

internal object CharacterDetailsReducer : Reducer<CharacterDetailsEffect, CharacterDetailsState> {

    override fun invoke(
        previousState: CharacterDetailsState,
        effect: CharacterDetailsEffect
    ): CharacterDetailsState {
        return when (effect) {
            is CharacterDetailsEffect.Data -> previousState.copy(character = effect.character)
            else -> previousState
        }
    }
}
