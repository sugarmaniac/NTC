package com.sugarmaniac.data

data class MainPageData(
    val bornToday: List<BornToday>,
    val featured: List<Featured>,
    val news: List<New>,
    val ontheaters: List<List<Ontheater>>,
    val platforms: List<Platform>,
    val popularArtists: List<PopularArtist>,
    val recentLists: List<RecentLists>,
    val topMovies: List<TopMovy>,
    val trailers: List<TrailerX>,
    val upcoming: List<List<Upcoming>>
)