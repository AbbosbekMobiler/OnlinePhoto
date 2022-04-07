package com.example.onlinephoto.api

import com.example.onlinephoto.Model.PhotoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @Headers("Authorization:563492ad6f9170000100000149fc4dff4c9e48e394f9ac4d5784e243")
    @GET("curated")
    fun getPhotos() : Call<BaseResponse<List<PhotoModel>>>
}