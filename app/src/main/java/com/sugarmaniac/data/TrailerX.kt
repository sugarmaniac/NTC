package com.sugarmaniac.data

data class TrailerX(
    val add_date: String,
    val add_date_ts: Int,
    val ago: String,
    val count: String,
    val embed_video_id: String,
    val id: Int,
    val info: String,
    val movie_id: Int,
    val movie_static_name: String,
    val movie_type: Int,
    val platforms: List<PlatformX>,
    val source: Source,
    val thumbnail: String,
    val title: String
)