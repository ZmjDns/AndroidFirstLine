package com.zmj.androidfirstline.notification

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_video_player.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/18
 * Description :
 */
class VideoPlayerAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_video_player)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        video.setVideoURI(uri)

        start.setOnClickListener {
            if (!video.isPlaying){
                video.start()
            }
        }

        pause.setOnClickListener {
            if (video.isPlaying){
                video.pause()
            }
        }

        replay.setOnClickListener {
            if (video.isPlaying){
                video.resume()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        video.suspend()
    }
}