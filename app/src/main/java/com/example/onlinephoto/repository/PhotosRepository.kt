package com.example.onlinephoto.repository

import androidx.lifecycle.MutableLiveData
import com.example.onlinephoto.Model.PhotoModel
import com.example.onlinephoto.api.BaseResponse
import com.example.onlinephoto.api.NetworkManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosRepository {
    fun getPhotos(error : MutableLiveData<String>,photosData : MutableLiveData<List<PhotoModel>>){
        NetworkManager.getApiClient().getPhotos().enqueue(object :
            Callback<BaseResponse<List<PhotoModel>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<PhotoModel>>>,
                response: Response<BaseResponse<List<PhotoModel>>>,
            ) {
                photosData.value = response.body()!!.photos
            }

            override fun onFailure(call: Call<BaseResponse<List<PhotoModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }
}