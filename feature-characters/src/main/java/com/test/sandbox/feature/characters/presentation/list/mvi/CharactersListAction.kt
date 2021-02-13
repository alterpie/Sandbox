package com.test.sandbox.feature.characters.presentation.list.mvi

internal sealed class CharactersListAction {
    object LoadCharacters : CharactersListAction()
}
