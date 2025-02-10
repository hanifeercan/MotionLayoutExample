package com.hercan.motionlayoutexample.core.network.source

import com.hercan.motionlayoutexample.core.network.dto.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET(".")
    suspend fun getCharacters(): Response<List<CharacterResponse>>
}