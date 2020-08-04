package com.zmj.androidfirstline

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

}