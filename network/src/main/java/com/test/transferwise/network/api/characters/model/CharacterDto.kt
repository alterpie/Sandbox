package com.test.transferwise.network.api.characters.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDto(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "species") val species: String,
    @Json(name = "gender") val gender: String,
    @Json(name = "url") val url: String,
    @Json(name = "status") val status: String,
    @Json(name = "type") val type: String,
    @Json(name = "episode") val episode: List<String>,
)
