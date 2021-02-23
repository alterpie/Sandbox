package com.test.sandbox.features.characters.presentation.list

import com.test.sandbox.features.characters.presentation.MviViewModel
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListAction
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListState
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListStore
import javax.inject.Inject

@JvmSuppressWildcards
internal class CharactersListViewModel @Inject constructor(
    store: CharactersListStore
) : MviViewModel<CharactersListState, CharactersListAction>(store) {

    init {
        store.acceptAction(CharactersListAction.LoadCharacters)
    }
}
