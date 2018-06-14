package com.youyu.arcviewpager

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by csc on 2018/6/12.
 * infomation：Banner部分因为我懒，所以直接使用的开源库的:https://github.com/youth5201314/banner;这个作者真的写的非常的不错，可以借鉴使用
 */
class MainActivity : AppCompatActivity() {

    var list:MutableList<String>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        //设置透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setTransparentStatusBar(true)
        }

        list= ArrayList<String>() as MutableList<String>?
        list?.add("https://manhua.qpic.cn/operation/0/11_11_22_c4de3602c8aff83100c018fce9f52d5c_1528687357296.jpg/0")
        list?.add("https://manhua.qpic.cn/operation/0/31_22_55_30aa7716ea9fd9abd139b10909d29d6e_1522508127196.jpg/0")
        list?.add("https://manhua.qpic.cn/operation/0/11_11_23_18a1debf5a249a4eeda00006ac467d01_1528687408905.jpg/0")
        list?.add("https://manhua.qpic.cn/operation/0/03_09_42_08ae84d5bd144070a8d5081062eb86b8_1525311724240.jpg/0")
        list?.add("https://manhua.qpic.cn/operation/0/11_11_23_2a169d0cbfff4864a8888da7c378627e_1528687424498.jpg/0")

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        banner.setIndicatorGravity(BannerConfig.CENTER)
        banner.isAutoPlay(true)
        banner.setDelayTime(2000)
        banner.setImageLoader(GlideImageLoader())
        banner.setImages(list)
        banner.start()
    }



    //设置透明状态栏
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    fun setTransparentStatusBar(boolean: Boolean){
        val window = window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (boolean){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        }else{
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        }
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT


    }


    override fun onDestroy() {
        banner.stopAutoPlay()
        super.onDestroy()
    }

}
