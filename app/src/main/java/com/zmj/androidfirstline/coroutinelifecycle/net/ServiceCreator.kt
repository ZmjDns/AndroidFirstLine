package com.zmj.androidfirstline.coroutinelifecycle.net

import com.zmj.androidfirstline.genericityanddelegent.build
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/28
 * Description :
 */
object ServiceCreator {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.caiyunapp.com/")
        .client(initOkHttp())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Synchronized
    private fun initOkHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .build()
    }

    fun <T>createServiceClass(service: Class<T>): T = retrofit.create(service)

    inline fun <reified T>serviceCreator(): T = createServiceClass(T::class.java)
}