package com.sugarmaniac.api

import com.sugarmaniac.data.MainPageData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface HomePageApi {

    @GET("https://www.sinemalar.com/api/test/v1/home")
    suspend fun getData() : Response<MainPageData>
}