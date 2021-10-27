package com.ashok.kanigiri.sneakershipapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("loadImageWithGlide")
fun loadImage(view: ImageView, url: String?) { // This methods should not have any return type, = declaration would make it return that object declaration.
    Glide.with(view.context).load(url).centerCrop().fitCenter().diskCacheStrategy(DiskCacheStrategy.DATA).into(view)
}