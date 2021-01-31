package com.test.transferwise.core.characters.model

data class Character(
    val id: Long,
    val name: String,
    val species: String,
    val gender: String,
    val image: String,
    val status: String,
    val episodes: List<String>,
)
