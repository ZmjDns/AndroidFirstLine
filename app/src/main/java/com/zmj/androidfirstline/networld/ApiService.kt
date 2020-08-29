package com.zmj.androidfirstline.networld

import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/27
 * Description :
 */
interface ApiService {

    @GET("{page}/data.json")
    fun getPathData(@Path("page") page: Int): Call<String>

    @GET("{page}/data/")
    fun getData(@Path("page") page: Int,@Query("token")token: String): Call<ResponseBody>

    @POST("upload/jsonData")
    fun uploadData(@Body jsonData: JSONArray): Call<ResponseBody>

    @Headers("user-agent:XMLrequest","use-cache:private")
    @GET("data.json")
    fun getHeaderJson(): Call<ResponseBody>
}