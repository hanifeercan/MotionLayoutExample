package com.hercan.motionlayoutexample.core.data.repo

import com.hercan.motionlayoutexample.core.data.model.Cartoon
import com.hercan.motionlayoutexample.core.network.dto.CartoonResponse
import retrofit2.Response

typealias RestResponse = Response<List<CartoonResponse>>

fun RestResponse.toCartoonList(): List<Cartoon> {
    return body()!!.map { cartoon ->
        Cartoon(
            creator = cartoon.creator,
            episodes = cartoon.episodes,
            id = cartoon.id,
            image = cartoon.image,
            runtimeInMinutes = cartoon.runtimeInMinutes,
            title = cartoon.title,
            year = cartoon.year
        )
    }
}