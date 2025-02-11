package com.hercan.motionlayoutexample.core.network.dto

import com.google.gson.annotations.SerializedName

data class CartoonResponse(
    @SerializedName("creator") val creator: List<String?>?,
    @SerializedName("episodes") val episodes: Int?,
    @SerializedName("genre") val genre: List<String?>?,
    @SerializedName("id") val id: Int?,
    @SerializedName("image") val image: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("runtime_in_minutes") val runtimeInMinutes: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("year") val year: Int?
)