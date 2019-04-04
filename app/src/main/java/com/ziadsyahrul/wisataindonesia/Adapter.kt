package com.ziadsyahrul.wisataindonesia

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.item_wisata.view.*

class Adapter(val data : List<DataWisata>) :  RecyclerView.Adapter<Adapter.MyHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_wisata, p0, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        p0.bind(data.get(p1))
    }

    class MyHolder (view: View) : RecyclerView.ViewHolder(view){
        fun bind(get: DataWisata) {
            itemView.itemName.text = get.nama_tempat
            itemView.itemLokasi.text = get.lokasi

            Glide.with(itemView)
                    .load(get.gambar)
//                    .listener(object : RequestListener<Drawable>{
//                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
//                            return false
//                        }
//
//                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
//                            return false
//                        }
//                    })
                    .into(itemView.itemImg)
        }

    }
}

