package com.zmj.androidfirstline.checpter7

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.SharedPreferences

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/14
 * Description :
 */
/**
 * SharedPreference扩展函数
 */

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.block()
    editor.apply()
}

fun contentValueOf(vararg pairs: Pair<String,Any?>) = ContentValues().apply{
    for (pair in pairs){
        val key = pair.first
        when(val value = pair.second){
            is Int -> put(key, value)
            is Long -> put(key, value)
            is String -> put(key, value)
            is Double -> put(key, value)
            is Float -> put(key, value)
            is Boolean -> put(key, value)
            is Byte -> put(key, value)
            is ByteArray -> put(key, value)
            null -> putNull(key)
        }
    }
}