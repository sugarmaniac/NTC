package com.sugarmaniac.data

data class Featured(
    val id: Int,
    val image: String,
    val name: String,
    val ontheaters: String,
    val org_name: String,
    val pub_date_formatted: String,
    val rating: Double,
    val recurrent: Boolean,
    val trailers: List<Trailer>
)