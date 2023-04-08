package com.sugarmaniac.data

data class New(
    val add_date: String,
    val ago: String,
    val id: Int,
    val image: String,
    val publish_date: String,
    val title: String,
    val ts: Int,
    val url: String,
    val video: Video
) : NewListInterface {
    override fun hasTrailer(): Boolean {
        return video == null
    }

    override fun takeImage(): String {
        return image
    }

    override fun takeName(): String {
        return title
    }

    override fun takeTimeAdded(): String {
        return ago
    }
}