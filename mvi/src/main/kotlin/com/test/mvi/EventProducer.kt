package com.test.mvi

interface EventProducer<Effect : Any> : (Effect) -> Event? {
    override fun invoke(effect: Effect): Event?
}
