package com.zmj.androidfirstline.common

import android.widget.Toast
import com.zmj.androidfirstline.App

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/14
 * Description :
 */
fun showToast(msg: String){
    Toast.makeText(App.appContext,msg,Toast.LENGTH_SHORT).show()
}