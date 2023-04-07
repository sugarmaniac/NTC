package com.sugarmaniac.data

data class Platform(
    val appImage: String,
    val id: Int,
    val name: String,
    val series: List<Sery>,
    val staticName: String,
    val suffix: String
)