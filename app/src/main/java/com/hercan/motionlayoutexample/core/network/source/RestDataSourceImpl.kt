package com.hercan.motionlayoutexample.core.network.source

import com.hercan.motionlayoutexample.core.network.dto.CartoonResponse
import retrofit2.Response
import javax.inject.Inject

class RestDataSourceImpl @Inject constructor(private val restApi: RestApi) : RestDataSource {
    override suspend fun getCartoons(): Response<List<CartoonResponse>> {
        return restApi.getCartoons()
    }
}