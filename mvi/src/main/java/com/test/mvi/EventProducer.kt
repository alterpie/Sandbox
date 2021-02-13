package com.test.mvi

interface EventProducer<Effect : Any, Event : Any> : (Effect) -> Event? {
    override fun invoke(effect: Effect): Event?
}
