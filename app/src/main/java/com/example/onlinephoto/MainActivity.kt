package com.example.onlinephoto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlinephoto.Adapter.PhotosAdapter
import com.example.onlinephoto.Model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerPhotos.layoutManager = GridLayoutManager(this,2)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.error.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.photosData.observe(this, Observer {
            recyclerPhotos.adapter = PhotosAdapter(it)
        })


        loadData()
    }
    fun loadData(){
        viewModel.getPhotos()
    }
}