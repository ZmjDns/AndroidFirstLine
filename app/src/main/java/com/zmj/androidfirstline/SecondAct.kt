package com.zmj.androidfirstline

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.act_second.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/4
 * Description :
 */
class SecondAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_second)

        val data = intent.getStringExtra("send_data")

        data?.let {
            Log.d("SecondAct",it)
        }
        Log.d("SecondAct","taskId is $taskId")

        openThridAct.setOnClickListener {
            startActivity(Intent(this,ThreadBrowserAct::class.java))
        }

    }


    override fun onBackPressed() {
        //super.onBackPressed()

        val intent = Intent()
        intent.putExtra("back_data","i am back_data")
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}