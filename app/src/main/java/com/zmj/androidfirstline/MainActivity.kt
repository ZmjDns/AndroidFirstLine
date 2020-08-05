package com.zmj.androidfirstline

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_hello.setOnClickListener{
            println()
        }

        btn_next.setOnClickListener {
            val intent = Intent("com.zmj.androidfirstline.ACTION_START").apply {
                addCategory("com.zmj.androidfirstline.MY_CATEGORY")
            }

            startActivity(intent)
        }

        btn_openBroser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://baidu.com")
            }
            startActivity(intent)
        }
        btn_sendAndGetData.setOnClickListener {
            val intent = Intent(this,SecondAct::class.java).apply {
                putExtra("send_data","hello")
            }
            startActivityForResult(intent,111)
        }
        btn_openDialogAct.setOnClickListener {
            val intent = Intent(this,DialogAct::class.java)
            startActivity(intent)
        }

        Log.d("MainActivity","onCreate.......")

        Log.d("MainActivity","taskId is $taskId")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            val backData = data?.getStringExtra("back_data")

            backData?.let {
                Log.d("MainActivity",it)
            }
        }
    }

    private fun largerNum(a: Int,b: Int) = max(a,b)

    var  ss: String? = null
    fun dailog(){

        val dailog = AlertDialog.Builder(this)
            .setTitle("sss")
            .setMessage("kkjkl")
            .setPositiveButton("confirm"){_, _ ->
                println("ndwnadknaka")
            }
        val lambda = {str: String -> str.length}

        ss?.let{it.length}
    }

    private fun getTextLength(text: String?) = text?.length ?: 0

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","onStart.......")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity","onRestart.......")
    }


    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","onResume.......")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","onPause.......")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","onStop.......")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","onDestroy.......")
    }

}