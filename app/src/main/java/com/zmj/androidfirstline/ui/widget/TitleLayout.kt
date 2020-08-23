package com.zmj.androidfirstline.ui.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.title.view.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
class TitleLayout(context: Context,attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)

        btn_back.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }

        btn_edit.setOnClickListener {
            Toast.makeText(context,"begin Edit",Toast.LENGTH_SHORT).show()
        }
    }
}