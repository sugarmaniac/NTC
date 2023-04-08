package com.sugarmaniac.data

data class Upcoming(
    val actors: List<Actor>,
    val countries: String,
    val duration: Int,
    val genres: String,
    val id: Int,
    val image: String,
    val name: String,
    val org_name: String,
    val produce_year: Int,
    val recurrent: String,
    val release_status: String,
    val url: String,
    val url_name: String
) : GeneralInterface{
    override fun takeUrl(): String {
        return image
    }

    override fun takeName(): String {
        return name
    }
}