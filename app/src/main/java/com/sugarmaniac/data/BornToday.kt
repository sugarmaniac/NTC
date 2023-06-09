package com.sugarmaniac.data

data class BornToday(
    val age: Int,
    val birthday: String,
    val death_date_formatted: String,
    val id: Int,
    val name_surname: String,
    val picture: String,
    val url: String
) : GeneralInterface {
    override fun takeUrl(): String {
        return picture
    }

    override fun takeName(): String {
        return name_surname
    }
}