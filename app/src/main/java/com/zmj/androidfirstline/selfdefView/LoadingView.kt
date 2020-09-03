package com.zmj.androidfirstline.selfdefView

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.zmj.androidfirstline.common.dp2px
import kotlin.math.abs

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/31
 * Description :
 */
class LoadingView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mMaxMove = dp2px(20)

    private var degree = 0f
        get() = field
        set(value) {
            field = value
            invalidate()
        }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas!!)
        val centerX = width/2f
        val centerY = height/2f
        mPaint.color = Color.YELLOW
        mPaint.strokeWidth = 20f
        mPaint.style = Paint.Style.FILL
        val shader = SweepGradient(centerX,centerY,Color.RED,Color.GREEN)
        mPaint.shader = shader
        canvas.save()
        canvas.rotate(degree,centerX,centerY)
        val loadingRadius = ((0.25 + 0.15 * precent()) * width / 2).toFloat()
        val path = Path()
        val loadingCircle = RectF(centerX - loadingRadius,centerY - loadingRadius,centerX + loadingRadius,centerY + loadingRadius)
        path.addArc(loadingCircle,270f,360f)
        canvas.drawPath(path,mPaint)
        canvas.restore()
    }

    fun precent(): Float{
        return abs(translationY) / mMaxMove
    }

    override fun setTranslationY(translationY: Float) {
        super.setTranslationY(translationY)
        invalidate()
    }

    fun startAnimator(){
        val objAnimator = ObjectAnimator.ofFloat(this,"degree",270f,720f)
        objAnimator.duration = 3000

        val scaleObjAnim = ObjectAnimator.ofFloat(this,"translationY",-mMaxMove,0f)
        scaleObjAnim.duration = 500

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(objAnimator,scaleObjAnim)
        animatorSet.start()
    }
}