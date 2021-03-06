package com.test.sandbox.network.api.characters.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.test.sandbox.network.model.InfoDto

@JsonClass(generateAdapter = true)
data class CharactersResponse(
    @Json(name = "info") val info: InfoDto,
    @Json(name = "results") val results: List<CharacterDto>,
)
