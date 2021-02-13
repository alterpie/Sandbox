package com.test.sandbox.feature.characters.presentation.list.mvi

import com.test.mvi.Store
import javax.inject.Inject

internal class CharactersListStore @Inject constructor(
    useCase: CharactersListUseCase,
) : Store<CharactersListState, CharactersListEffect, CharactersListAction>(
    CharactersListState.INITIAL,
    useCase,
    CharactersListReducer,
    CharactersListEventProducer
)
