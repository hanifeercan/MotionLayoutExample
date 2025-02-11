package com.hercan.motionlayoutexample.core.network.source

import com.hercan.motionlayoutexample.core.network.dto.CartoonResponse
import retrofit2.Response

interface RestDataSource {
    suspend fun getCartoons(): Response<List<CartoonResponse>>
}