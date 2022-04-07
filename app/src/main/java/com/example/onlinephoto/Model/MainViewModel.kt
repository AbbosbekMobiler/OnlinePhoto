package com.example.onlinephoto.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinephoto.api.Api
import com.example.onlinephoto.api.BaseResponse
import com.example.onlinephoto.api.NetworkManager
import com.example.onlinephoto.repository.PhotosRepository
import com.example.onlinephoto.utils.CONSTANTS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel:ViewModel() {

    val repository = PhotosRepository()
    val error = MutableLiveData<String>()
    val photosData = MutableLiveData<List<PhotoModel>>()

    fun getPhotos(){
        repository.getPhotos(error,photosData)
    }
}