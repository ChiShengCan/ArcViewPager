package com.youyu.arcviewpager

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

/**
 * Created by csc on 2018/6/13.
 * infomation：有弧度ImageView(注意使用的时候需要灵活使用,主要的是适当的修改一下偏移量offset即可满足需求)
 */
class ArcImageView(context: Context) : AppCompatImageView(context){

    lateinit var mPaint: Paint
    lateinit var mPath: Path

    lateinit var mContext: Context

    //控件的宽
    var mWidth:Float=0F
    //控件的高
    var mHeight:Float=0F

    //偏移量(注意在程序中需要适当的修改一下偏移量才能满足你的需求)
    var offset:Float=80F

    constructor(context: Context,attrs: AttributeSet): this(context) {
        mContext=context

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mWidth=w.toFloat()
        mHeight=h.toFloat()

        mPath = Path()
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        //设置弧形下部分需要填充的颜色
        mPaint.color = Color.WHITE
        mPaint.style = Paint.Style.FILL_AND_STROKE

    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //控制着幅度的高度(这个主要控制弧形的高度,如果想要幅度大一点，就把这个值修改大一些即可)
        var h:Float=(mHeight/8)*7

        mPath.moveTo(0F,h)

        /***
         * 二阶贝塞尔曲线
         *  在程序中适当的修改一下offset定制自己的需求
         */
        mPath.quadTo(mWidth/2,mHeight+offset,mWidth,h)


        mPath.lineTo(mWidth, mHeight+offset)
        mPath.lineTo(0.0F, mHeight+offset)

        canvas?.drawPath(mPath,mPaint)
    }

}