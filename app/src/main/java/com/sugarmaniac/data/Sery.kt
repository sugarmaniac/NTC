package com.sugarmaniac.data

data class Sery(
    val countries: List<Any>,
    val duration: Int,
    val genres: Any,
    val id: Int,
    val image: String,
    val name: String,
    val produceYear: Int,
    val pubDate: String,
    val ratingStr: String,
    val seasonCount: Int,
    val summary: String,
    val tmdbPopularity: Double,
    val type: Int,
    val url: String
) : GeneralInterface{
    override fun takeUrl(): String {
        return image
    }

    override fun takeName(): String {
        return name
    }
}