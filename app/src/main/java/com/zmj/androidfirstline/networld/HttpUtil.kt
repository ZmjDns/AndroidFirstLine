package com.zmj.androidfirstline.networld

import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/27
 * Description :
 */
object HttpUtil {

    fun sendOKHttpRequest(address: String,callBack: Callback){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(address)
            .build()
        client.newCall(request).enqueue(callBack)
    }
}