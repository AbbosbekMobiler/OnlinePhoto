package com.example.onlinephoto.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlinephoto.Model.PhotoModel
import com.example.onlinephoto.R
import com.example.onlinephoto.utils.CONSTANTS
import kotlinx.android.synthetic.main.photos_item_layout.view.*

class PhotosAdapter(val items : List<PhotoModel>):RecyclerView.Adapter<PhotosAdapter.ItemHolder>() {
    inner class ItemHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.photos_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = items[position]

        Glide.with(holder.itemView.context).load(item.src.original).into(holder.itemView.imgPhotos)

    }

    override fun getItemCount(): Int {
        return items.count()
    }
}