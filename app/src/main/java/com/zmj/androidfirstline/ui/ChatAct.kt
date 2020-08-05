package com.zmj.androidfirstline.ui

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import com.zmj.permissionx.PermissionX

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
class ChatAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_chat)

        PermissionX.request(this,Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE){allGranted,deniedList ->
            if (allGranted){
                Toast.makeText(this,"申请权限成功",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
            }
        }
    }




}