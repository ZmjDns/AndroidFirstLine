package com.zmj.androidfirstline.coroutinelifecycle

import androidx.lifecycle.liveData
import com.zmj.androidfirstline.coroutinelifecycle.data.PlaceResponse
import com.zmj.androidfirstline.coroutinelifecycle.net.NetRepository
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

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

    fun getReducePlaces(query: String) = fire(Dispatchers.IO){
        val resp = NetRepository.getPlace(query)
        if (resp.status == "ok"){
            Result.success(resp)
        }else{
            Result.failure(RuntimeException(""))
        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) = liveData<Result<T>>(context){
        val result = try {
            block()
        }catch (e: Exception){
            Result.failure<T>(e)
        }
        emit(result)
    }
}