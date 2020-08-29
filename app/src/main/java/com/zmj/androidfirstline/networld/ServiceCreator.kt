package com.zmj.androidfirstline.networld

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/27
 * Description :
 */
object ServiceCreator {

    private const val BASE_URL = "http://192.168.1.254:8080/YYApi/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okClient())
        .build()

    fun <T>createService(service:Class<T>): T = retrofit.create(service)

    inline fun <reified T>create(): T = createService(T::class.java)



    private fun okClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

}