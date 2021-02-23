package com.test.sandbox.features.characters.presentation.details.mvi

import com.test.mvi.Store
import javax.inject.Inject

internal class CharacterDetailsStore @Inject constructor(
    actor: CharacterDetailsActor,
) : Store<CharacterDetailsState, CharacterDetailsEffect, CharacterDetailsAction>(
    CharacterDetailsState.INITIAL,
    actor,
    CharacterDetailsReducer,
    CharacterDetailsEventProducer,
    "CharacterDetails"
)
