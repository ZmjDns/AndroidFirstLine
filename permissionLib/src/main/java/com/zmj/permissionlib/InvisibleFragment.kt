package com.zmj.permissionlib

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/24
 * Description :
 */

typealias PermissionCallBack = (Boolean,List<String>) -> Unit
class InvisibleFragment: Fragment() {

    private var callBack: PermissionCallBack? = null

    fun requestNow(cb: PermissionCallBack,vararg permissions: String){
        callBack = cb
        requestPermissions(permissions,1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == 1){
            val denyList = ArrayList<String>()
            for ((index,result) in grantResults.withIndex()){
                if (result != PackageManager.PERMISSION_GRANTED){
                    denyList.add(permissions[index])
                }
            }
            val allGranted = denyList.isEmpty()
            callBack?.let { it(allGranted,denyList) }
        }
    }

}