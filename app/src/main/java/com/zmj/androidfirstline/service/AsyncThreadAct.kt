package com.zmj.androidfirstline.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_async_thread.*
import kotlin.concurrent.thread

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/20
 * Description :
 */
class AsyncThreadAct: AppCompatActivity() {

    private val handler = object :Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){
                101 -> tv.text = "nice to meet you"
            }
        }
    }


    private lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object: ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("AsyncThreadAct","onServiceDisconnected......")
        }
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_async_thread)

        btn.setOnClickListener {
            Log.d("AsyncThreadAct","into click")
            thread{
                val message = Message()
                message.what = 101
                //message.obj = "nice to meet you"
                handler.sendMessage(message)
                Log.d("AsyncThreadAct","send message")
            }
        }

        startS.setOnClickListener {
            startService(Intent(this,MyService::class.java))
        }

        stopS.setOnClickListener {
            stopService(Intent(this,MyService::class.java))
        }

        bindS.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            bindService(intent,connection,Context.BIND_AUTO_CREATE)
        }

        unbindS.setOnClickListener {
            unbindService(connection)
        }

    }
}