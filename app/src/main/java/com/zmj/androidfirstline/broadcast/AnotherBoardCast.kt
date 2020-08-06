package com.zmj.androidfirstline.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
class AnotherBoardCast: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"i am another boardCast",Toast.LENGTH_SHORT).show()
        Log.d("AnotherBoardCast","i am another boardCast")
    }
}