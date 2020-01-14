package com.eferraz.shufflesongs.infra

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.load(artworkUrl: String) =
    Glide.with(this).load(artworkUrl).transform(RoundedCorners(100)).into(this)