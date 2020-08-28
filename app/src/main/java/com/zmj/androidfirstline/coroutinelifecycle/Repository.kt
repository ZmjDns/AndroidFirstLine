package com.zmj.androidfirstline.coroutinelifecycle

import androidx.lifecycle.liveData
import com.zmj.androidfirstline.coroutinelifecycle.data.PlaceResponse
import com.zmj.androidfirstline.coroutinelifecycle.net.NetRepository
import kotlinx.coroutines.Dispatchers

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/28
 * Description :
 */
object Repository {

    fun getPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val places = NetRepository.getPlace(query)
            Result.success(places)
        }catch (e: Exception){
            Result.failure<PlaceResponse>(e)
        }
        emit(result)
    }
}