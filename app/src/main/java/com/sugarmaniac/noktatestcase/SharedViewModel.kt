package com.sugarmaniac.noktatestcase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sugarmaniac.api.ApiService
import com.sugarmaniac.data.*
import kotlinx.coroutines.launch

class SharedViewModel:  ViewModel() {

    private val apiService = ApiService()
    private var mainPageData : MainPageData? = null

    val featuredItems = MutableLiveData<List<Featured>>(emptyList())
    val onTheatersItems = MutableLiveData<List<List<Ontheater>>>(emptyList())
    val upComingItems = MutableLiveData<List<Upcoming>>(emptyList())
    val topMovies = MutableLiveData<List<TopMovy>>(emptyList())
    val trailers = MutableLiveData<List<TrailerX>>(emptyList())
    val news = MutableLiveData<List<New>>(emptyList())
    val bornTodays = MutableLiveData<List<BornToday>>(emptyList())
    val recentLists = MutableLiveData<List<RecentLists>>(emptyList())
    val popularArtist = MutableLiveData<List<PopularArtist>>(emptyList())
    val platforms = MutableLiveData<List<Platform>>(emptyList())


    init {
        fetchMainPage()
    }

    private fun fetchMainPage(){
        viewModelScope.launch {
            mainPageData = apiService.getDeviceDetail().body()
            featuredItems.value = mainPageData?.featured ?: emptyList()
            onTheatersItems.value = mainPageData?.ontheaters ?: emptyList()
            upComingItems.value = mainPageData?.upcoming?.flatten() ?: emptyList()
            topMovies.value = mainPageData?.topMovies ?: emptyList()
            topMovies.value = mainPageData?.topMovies ?: emptyList()
            trailers.value = mainPageData?.trailers ?: emptyList()
            news.value = mainPageData?.news ?: emptyList()
            bornTodays.value = mainPageData?.bornToday ?: emptyList()
            recentLists.value = mainPageData?.recentLists ?: emptyList()
            popularArtist.value = mainPageData?.popularArtists ?: emptyList()
            platforms.value = mainPageData?.platforms ?: emptyList()
        }
    }

    fun getPlatformItems(position : Int): List<Sery> {
        return platforms.value?.get(position)?.series ?: emptyList()
    }

}