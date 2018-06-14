package com.youyu.arcviewpager

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * Created by csc on 2018/6/14.
 * information：在这里应用我们自定义的弧形ImageView即可
 */
class GlideImageLoader : ImageLoader(){

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        Glide.with(context).load(path).into(imageView)
    }

    override fun createImageView(context: Context?): ImageView {
        var image:ArcImageView=ArcImageView(context!!)
        return image
    }


}
