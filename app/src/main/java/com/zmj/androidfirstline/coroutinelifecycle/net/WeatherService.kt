package com.zmj.androidfirstline.coroutinelifecycle.net

import com.zmj.androidfirstline.App
import com.zmj.androidfirstline.coroutinelifecycle.data.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/28
 * Description :
 */
interface WeatherService {

    @GET("v2/place?token=${App.TOKEN}&lang=zh_CN")
    fun getPlaces(@Query("query") city: String): Call<PlaceResponse>
}