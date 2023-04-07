package com.sugarmaniac.data

data class Ontheater(
    val actors: List<Actor>,
    val countries: String,
    val duration: Int,
    val genres: String,
    val id: Int,
    val image: String,
    val name: String,
    val org_name: String,
    val produce_year: Int,
    val recurrent: Boolean,
    val release_status: String,
    val url: String,
    val url_name: String
)