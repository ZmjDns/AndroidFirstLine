package com.zmj.androidfirstline.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_notification.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/17
 * Description :
 */
class NotificationAct: AppCompatActivity() {

    private lateinit var manager : NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_notification)

        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        sendNotification.setOnClickListener {
            createNotification()
        }
        impNotification.setOnClickListener {
            createImportantNotification()
        }

    }

    private fun createNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("normal","Normal",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        val intent = Intent(this,PendingAct::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intent,0)
        val notification = NotificationCompat.Builder(this,"normal")
            .setContentTitle("This is content title")
            .setContentText("This is content text")
            .setSmallIcon(R.drawable.message_left_original)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.ic_launcher_background))
            .setContentIntent(pendingIntent)
            //.setAutoCancel(true)        //点击通知之后自动取消
            //setStyle会覆盖掉setContentText（），并且后面的setStyle会覆盖掉前面的
            .setStyle(NotificationCompat.BigTextStyle().bigText("learn how to build notifications,send and sync data,and use voice actions.Get the offical Android IDE and developer tools to build apps for Android."))
            .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources,R.drawable.message_right_original)))
            .build()

        manager.notify(1,notification)
    }

    private fun createImportantNotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importantChannel = NotificationChannel("important","Important",NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(importantChannel)
        }

        val intent = Intent(this,PendingAct::class.java)
        val pi = PendingIntent.getActivity(this,0,intent,0)

        val importantNotifi = NotificationCompat.Builder(this,"important")
            .setContentTitle("important title")
            .setContentText("important content")
            .setSmallIcon(R.drawable.message_right_original)
            .setLargeIcon(BitmapFactory.decodeResource(applicationContext.resources,R.drawable.message_left_original))
            .setContentIntent(pi)
            .build()

        manager.notify(2,importantNotifi)

    }

}