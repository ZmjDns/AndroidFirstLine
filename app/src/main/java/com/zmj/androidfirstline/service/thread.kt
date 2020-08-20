package com.zmj.androidfirstline.service

import kotlin.concurrent.thread

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/20
 * Description :
 */

fun main() {
    thread {
        println("huihuhijj....")
    }

    Thread{
        println("huihuhijj....jjhpjipkp")
    }.start()
}