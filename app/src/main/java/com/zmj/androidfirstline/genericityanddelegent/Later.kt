package com.zmj.androidfirstline.genericityanddelegent

import kotlin.reflect.KProperty

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/17
 * Description :
 */

fun <T> later(block: () -> T) = Later(block)

class Later<T>(val block: () -> T){
    var value: Any? = null

    operator fun getValue(any: Any?,prop: KProperty<*>): T{
        if (value == null){
            value = block
        }
        return value as T
    }
}

fun main() {
    val p by later {
        println("init p");
        "test later"
    }
    println(p)
}