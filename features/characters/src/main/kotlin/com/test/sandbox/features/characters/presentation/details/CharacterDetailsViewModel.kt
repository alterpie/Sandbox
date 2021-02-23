package com.test.sandbox.features.characters.presentation.details

import com.test.sandbox.features.characters.presentation.MviViewModel
import com.test.sandbox.features.characters.presentation.details.mvi.CharacterDetailsAction
import com.test.sandbox.features.characters.presentation.details.mvi.CharacterDetailsState
import com.test.sandbox.features.characters.presentation.details.mvi.CharacterDetailsStore
import javax.inject.Inject

@JvmSuppressWildcards
internal class CharacterDetailsViewModel @Inject constructor(
    store: CharacterDetailsStore
) : MviViewModel<CharacterDetailsState, CharacterDetailsAction>(store) {

    init {
        acceptAction(CharacterDetailsAction.LoadCharacter)
    }
}
