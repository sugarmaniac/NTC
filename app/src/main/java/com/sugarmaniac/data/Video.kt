package com.sugarmaniac.data

data class Video(
    val embed_url: String,
    val embed_video_id: String,
    val id: Int,
    val params: Params,
    val source: Source,
    val thumbnail: String,
    val title: String
)