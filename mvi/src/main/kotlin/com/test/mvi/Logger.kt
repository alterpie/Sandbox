package com.test.mvi

fun interface Logger {
    fun log(tag: String, message: String)
}
