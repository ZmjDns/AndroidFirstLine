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
class MyBroadCastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"Received my broadcast",Toast.LENGTH_SHORT).show()
        Log.d("MyBroadCastReceiver","Received my broadcast")
        //阻止广播往下传
        abortBroadcast()
    }
}