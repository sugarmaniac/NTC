package com.sugarmaniac.api

import com.sugarmaniac.data.MainPageData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val BASE_DEVICE_URL = "https://192.168.0.1/"

    private val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_DEVICE_URL)
        .build()
        .create(HomePageApi::class.java)

    suspend fun getDeviceDetail(string: String): Response<MainPageData> {
        return api.getData(string)
    }
}