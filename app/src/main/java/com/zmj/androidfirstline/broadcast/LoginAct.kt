package com.zmj.androidfirstline.broadcast

import android.content.Intent
import android.os.Bundle
import com.zmj.androidfirstline.MainActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_login.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
class LoginAct: BaseAct() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_login)


        btn_login.setOnClickListener {
            val pass = pass.text.toString()
            if (pass == "123"){
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}