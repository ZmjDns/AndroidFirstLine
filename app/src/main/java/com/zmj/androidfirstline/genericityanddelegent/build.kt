package com.zmj.androidfirstline.genericityanddelegent

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/17
 * Description :
 */

fun <T> T.build(block: T.() -> Unit): T{
    block()
    return this
}