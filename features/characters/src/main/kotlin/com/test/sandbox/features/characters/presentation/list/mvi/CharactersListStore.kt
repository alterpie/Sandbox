package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.mvi.Store
import javax.inject.Inject

internal class CharactersListStore @Inject constructor(
    useCase: CharactersListActor,
) : Store<CharactersListState, CharactersListEffect, CharactersListAction>(
    CharactersListState.INITIAL,
    useCase,
    CharactersListReducer,
    CharactersListEventProducer,
    "CharacterList"
)
