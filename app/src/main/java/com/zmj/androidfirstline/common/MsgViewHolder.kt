package com.zmj.androidfirstline.common

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.msg_left_item.view.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
sealed class MsgViewHolder(view: View): RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View): MsgViewHolder(view){
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View): MsgViewHolder(view){
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)
}

