package com.zmj.androidfirstline

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_thrid_browser.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/4
 * Description :
 */
class ThreadBrowserAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_thrid_browser)

        Log.d("ThreadBrowserAct","taskId is $taskId")

        btn_openSecond.setOnClickListener {
            startActivity(Intent(this,SecondAct::class.java))
        }
    }

}