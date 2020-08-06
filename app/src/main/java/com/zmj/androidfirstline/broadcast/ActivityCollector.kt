package com.zmj.androidfirstline.broadcast

import android.app.Activity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
object ActivityCollector {

    private val actList = ArrayList<Activity>()

    fun addActivity(act: Activity){
        actList.add(act)
    }

    fun removeAct(act: Activity){
        actList.remove(act)
    }

    fun removeAllAct(){
        for (act in actList){
            if (!act.isFinishing){
                act.finish()
            }
        }
        actList.clear()
    }
}