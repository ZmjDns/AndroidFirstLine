package com.zmj.androidfirstline.service

import android.content.Context
import android.content.Intent
import com.zmj.androidfirstline.App

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/20
 * Description :
 */

inline fun <reified T> getGenericType() = T::class.java
inline fun <reified R> startAct(context: Context){
    context.startActivity(Intent(context,R::class.java))
}
inline fun <reified T> startActivity(context: Context,block:Intent.() -> Unit){
    val intent = Intent(context,T::class.java)
    intent.block()
    context.startActivity(intent)
}

fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1:$result1   result2: $result2")

    startActivity<AsyncThreadAct>(App.appContext){
        putExtra("asss","scascca")
        putExtra("dasdsa",123)
    }
}