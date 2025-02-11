package com.hercan.motionlayoutexample.core.data.repo

import com.hercan.motionlayoutexample.core.data.model.CharacterModel
import com.hercan.motionlayoutexample.core.network.dto.CartoonResponse
import retrofit2.Response

typealias RestResponse = Response<List<CartoonResponse>>

fun RestResponse.toCharacterModelList(): List<CharacterModel> {
    return body()!!.map { character ->
        CharacterModel(
            creator = character.creator,
            episodes = character.episodes,
            id = character.id,
            image = character.image,
            runtimeInMinutes = character.runtimeInMinutes,
            title = character.title,
            year = character.year
        )
    }
}