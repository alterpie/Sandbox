package com.test.sandbox.feature.characters.presentation.list.mvi

internal sealed class CharactersListEvent {
    data class Error(val throwable: Throwable) : CharactersListEvent()
}
