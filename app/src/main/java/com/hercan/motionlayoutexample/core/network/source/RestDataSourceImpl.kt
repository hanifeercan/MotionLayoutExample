package com.hercan.motionlayoutexample.core.network.source

import com.hercan.motionlayoutexample.core.network.dto.CharacterResponse
import retrofit2.Response
import javax.inject.Inject

class RestDataSourceImpl @Inject constructor(private val restApi: RestApi) : RestDataSource {
    override suspend fun getCharacters(): Response<List<CharacterResponse>> {
        return restApi.getCharacters()
    }
}