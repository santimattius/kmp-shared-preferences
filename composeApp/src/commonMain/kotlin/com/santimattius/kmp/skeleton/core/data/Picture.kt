package com.santimattius.kmp.skeleton.core.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    @SerialName("id") val id: String,
    @SerialName("author") val author: String,
    @SerialName("width") val width: Long,
    @SerialName("height") val height: Long,
    @SerialName("url") val url: String,
    @SerialName("download_url") val downloadURL: String,
)
