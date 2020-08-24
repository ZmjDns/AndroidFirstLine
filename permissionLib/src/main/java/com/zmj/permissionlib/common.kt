package com.zmj.permissionlib

import android.nfc.Tag
import androidx.fragment.app.FragmentActivity

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/24
 * Description :
 */

object Permission{

    private const val Tag = "PermissionFragment"

    fun request(activity: FragmentActivity,vararg permission: String,callBack: PermissionCallBack){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(Tag)
        val fragment = if (existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment =  InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, Tag).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callBack,*permission)
    }
}
