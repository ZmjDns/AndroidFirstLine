package com.zmj.androidfirstline

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.zmj.androidfirstline.apklinstall.ApkInstallAct
import com.zmj.androidfirstline.broadcast.BaseAct
import com.zmj.androidfirstline.checpter7.WriteFileAct
import com.zmj.androidfirstline.coroutinelifecycle.mvvm.PlacesAct
import com.zmj.androidfirstline.networld.WebViewAct
import com.zmj.androidfirstline.notification.CameraAct
import com.zmj.androidfirstline.notification.MediaPlayerAct
import com.zmj.androidfirstline.notification.NotificationAct
import com.zmj.androidfirstline.notification.VideoPlayerAct
import com.zmj.androidfirstline.selfdefView.SportsView
import com.zmj.androidfirstline.service.AsyncThreadAct
import com.zmj.androidfirstline.ui.ChatAct
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max

class MainActivity : BaseAct() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        tv_hello.setOnClickListener{
            println()
        }

        btn_next.setOnClickListener {
            val intent = Intent("com.zmj.androidfirstline.ACTION_START").apply {
                addCategory("com.zmj.androidfirstline.MY_CATEGORY")
            }

            startActivity(intent)
        }

        btn_openBroser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://baidu.com")
            }
            startActivity(intent)
        }
        btn_sendAndGetData.setOnClickListener {
            val intent = Intent(this,SecondAct::class.java).apply {
                putExtra("send_data","hello")
            }
            startActivityForResult(intent,111)
        }
        btn_openDialogAct.setOnClickListener {
            val intent = Intent(this,DialogAct::class.java)
            startActivity(intent)
        }
        btn_chat.setOnClickListener {
            startActivity(Intent(this,ChatAct::class.java))
        }
        btn_sendBoardCast.setOnClickListener {
            val intent = Intent("com.zmj.androidfirstline.MY_BROSDCAST")
            intent.setPackage(packageName)
            //标准广播
            //sendBroadcast(intent)
            //有序广播
            sendOrderedBroadcast(intent,null)
        }
        forceOffline.setOnClickListener {
            val intent = Intent("com.zmj.androidfirstline.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
        chapter7.setOnClickListener {
            startActivity(Intent(this,WriteFileAct::class.java))
        }

        notification.setOnClickListener {
            startActivity(Intent(this,NotificationAct::class.java))
        }

        camera.setOnClickListener {
            startActivity(Intent(this,CameraAct::class.java))
        }

        media.setOnClickListener {
            startActivity(Intent(this,MediaPlayerAct::class.java))
        }

        video.setOnClickListener {
            startActivity(Intent(this,VideoPlayerAct::class.java))
        }
        service.setOnClickListener {
            startActivity(Intent(this,AsyncThreadAct::class.java))
        }
        install.setOnClickListener {
            startActivity(Intent(this,ApkInstallAct::class.java))
        }

        webView.setOnClickListener {
            startActivity(Intent(this,WebViewAct::class.java))
        }

        CoroutineWithLiveData.setOnClickListener {
            startActivity(Intent(this,PlacesAct::class.java))
        }

        sportView.setOnClickListener { startActivity(Intent(this,SportsView::class.java)) }

        Log.d("MainActivity","onCreate.......")

        Log.d("MainActivity","taskId is $taskId")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            val backData = data?.getStringExtra("back_data")

            backData?.let {
                Log.d("MainActivity",it)
            }
        }
    }

    private fun largerNum(a: Int,b: Int) = max(a,b)

    var  ss: String? = null
    fun dailog(){

        val dailog = AlertDialog.Builder(this)
            .setTitle("sss")
            .setMessage("kkjkl")
            .setPositiveButton("confirm"){_, _ ->
                println("ndwnadknaka")
            }
        val lambda = {str: String -> str.length}

        ss?.let{it.length}
    }

    private fun getTextLength(text: String?) = text?.length ?: 0

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart.......")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity","onRestart.......")
    }


    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume.......")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause.......")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop.......")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestroy.......")
    }

}