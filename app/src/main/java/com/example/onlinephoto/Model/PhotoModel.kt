package com.example.onlinephoto.Model

data class PhotoModel(
    val src : Src,
    val photographer : String
)
data class Src(
    val original : String
)