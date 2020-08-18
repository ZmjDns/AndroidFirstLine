package com.zmj.androidfirstline.notification

import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/17
 * Description :
 */
class PendingAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_pending)

        val notiManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notiManager.cancel(1)
    }
}