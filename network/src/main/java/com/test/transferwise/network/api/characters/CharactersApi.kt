package com.test.transferwise.network.api.characters

import com.test.transferwise.network.api.characters.model.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharactersResponse

}
