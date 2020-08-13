package com.zmj.androidfirstline.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/13
 * Description :
 */

fun main() {
    val job = Job()
    val scope = CoroutineScope(job)

    scope.launch {
        println("launch1")
    }

    scope.launch {
        println("launch2")
    }

    runBlocking {
        val start = System.currentTimeMillis()
        val result = async { delay(1000); 5 + 5 }
        val result2 = async { delay(1000); 5+5 }
        println("result: ${result.await() + result2.await()}")
        val end = System.currentTimeMillis()
        println("const time: ${end - start}")
    }

}

suspend fun request(address: String): String{
    return suspendCoroutine {contintation ->
        object :HttpCallBackListener{
            override fun onFinish(resp: String) {
                contintation.resume(resp)
            }

            override fun onError(e: Exception) {
                contintation.resumeWithException(e)
            }
        }
    }
}

interface HttpCallBackListener{
    fun onFinish(resp: String)

    fun onError(e: Exception)
}