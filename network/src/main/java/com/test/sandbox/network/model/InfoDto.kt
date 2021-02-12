package com.test.sandbox.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoDto(@Json(name = "pages") val pages: Int)
