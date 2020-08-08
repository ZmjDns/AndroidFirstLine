package com.zmj.androidfirstline.broadcast

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
class ForceOffLineReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("ForceOffLineReceiver","ForceOffLineReceiver")

        AlertDialog.Builder(context).apply {
            setTitle("提示")
            setMessage("您被强制下线，请重新登录")
            setCancelable(false)
            setPositiveButton("OK"){_, _ ->
                ActivityCollector.removeAllAct()
                context?.let {
                    it.startActivity(Intent(it,LoginAct::class.java))
                }
            }
        }.show()
    }
}