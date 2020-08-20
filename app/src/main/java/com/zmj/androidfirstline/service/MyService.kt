package com.zmj.androidfirstline.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.zmj.androidfirstline.R

class MyService : Service() {

    private val mBinder = DownloadBinder()

    override fun onCreate() {
        super.onCreate()
        createForegroundService()
        Log.d("MyService","MyService onCreate.......")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.d("MyService","MyService onStartCommand.......")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    private fun createForegroundService(){
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("my_service","前台通知",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this,AsyncThreadAct::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,"my_service")
            .setContentTitle("title")
            .setContentText("content")
            .setContentIntent(pi)
            .setSmallIcon(R.drawable.message_right_original)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.message_left_original))
            .build()
        startForeground(1,notification)
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService","MyService onDestroy.......")
    }


    class DownloadBinder: Binder(){

        fun startDownload() {
            Log.d("MyService","DownloadBinder startDownload.......")
        }

        fun getProgress(): Int{
            Log.d("MyService","DownloadBinder getProgress.......")
            return 0
        }
    }
}
