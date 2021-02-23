package com.test.sandbox.features.characters.presentation.list.mvi

import com.test.sandbox.libraries.characters.model.Character


internal sealed class CharactersListAction {
    object LoadCharacters : CharactersListAction()
    data class OpenDetails(val character: Character) : CharactersListAction()
}
