package com.hercan.motionlayoutexample.core.network.source

import com.hercan.motionlayoutexample.core.network.dto.CartoonResponse
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET(".")
    suspend fun getCartoons(): Response<List<CartoonResponse>>
}