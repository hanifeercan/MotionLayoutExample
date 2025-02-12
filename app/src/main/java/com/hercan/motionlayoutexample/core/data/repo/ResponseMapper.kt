package com.hercan.motionlayoutexample.core.data.repo

import com.hercan.motionlayoutexample.core.data.model.Cartoon
import com.hercan.motionlayoutexample.core.network.dto.CartoonResponse
import retrofit2.Response

typealias RestResponse = Response<List<CartoonResponse>>

fun RestResponse.toCartoonList(): List<Cartoon> {
    return body()!!.map { cartoon ->
        val unknown = "Unknown"
        Cartoon(
            creator = cartoon.creator?.joinToString(", ") ?: unknown,
            episodes = "🎬 " + cartoon.episodes.toString() + " Episode",
            id = cartoon.id,
            image = cartoon.image,
            runtimeInMinutes = "⌚ " + cartoon.runtimeInMinutes.toString() + " Run time min",
            title = cartoon.title.toString(),
            year = cartoon.year.toString()
        )
    }
}