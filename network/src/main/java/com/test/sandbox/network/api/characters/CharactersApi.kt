package com.test.sandbox.network.api.characters

import com.test.sandbox.network.api.characters.model.CharacterDto
import com.test.sandbox.network.api.characters.model.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApi {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharactersResponse

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") id: Long): CharacterDto

}
