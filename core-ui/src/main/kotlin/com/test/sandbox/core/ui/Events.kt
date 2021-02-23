package com.test.sandbox.core.ui

import androidx.navigation.NavDirections
import com.test.mvi.Event

sealed class NavigationEvent : Event
object NavigateUp : NavigationEvent()
data class Navigate(val direction: NavDirections) : NavigationEvent()

sealed class ErrorEvent(open val throwable: Throwable) : Event {
    data class Short(override val throwable: Throwable) : ErrorEvent(throwable)
    data class Long(override val throwable: Throwable) : ErrorEvent(throwable)
    data class Indefinite(override val throwable: Throwable) : ErrorEvent(throwable)
}
