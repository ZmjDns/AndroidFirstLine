package com.zmj.androidfirstline.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
open class BaseAct: AppCompatActivity() {

    lateinit var receiver: ForceOffLineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        //在此注册广播，保证处于顶部的Act注册广播
        val intent = IntentFilter("com.zmj.androidfirstline.FORCE_OFFLINE")
        receiver = ForceOffLineReceiver()
        registerReceiver(receiver,intent)
    }

    override fun onPause() {
        super.onPause()
        //在此处取消注册广播,保证不在栈顶的act不再注册
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeAct(this)
    }
}