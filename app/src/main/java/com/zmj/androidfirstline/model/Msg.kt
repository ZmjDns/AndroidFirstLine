package com.zmj.androidfirstline.model

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
class Msg(val content: String,val type: Int) {

    companion object{
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }

}