package com.example.onlinephoto.api

import com.example.onlinephoto.utils.CONSTANTS
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    var retrofit : Retrofit ?= null
    fun getApiClient(): Api {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(CONSTANTS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }
}