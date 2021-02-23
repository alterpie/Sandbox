package com.test.sandbox.features.characters.presentation.list.mvi

internal sealed class CharactersListEvent {
    data class Error(val throwable: Throwable) : CharactersListEvent()
}
