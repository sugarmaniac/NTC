package com.sugarmaniac.data

import com.sugarmaniac.rvadapters.NewsListItemAdapter

data class RecentLists(
    val ago: String,
    val description: String,
    val id: Int,
    val image: String,
    val title: String
) : NewListInterface {
    override fun hasTrailer(): Boolean {
        return false
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