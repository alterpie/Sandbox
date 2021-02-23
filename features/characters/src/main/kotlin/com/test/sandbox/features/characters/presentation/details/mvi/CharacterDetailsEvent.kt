package com.test.sandbox.features.characters.presentation.details.mvi

internal sealed class CharacterDetailsEvent {
    data class Error(val throwable: Throwable) : CharacterDetailsEvent()
}
