package com.zmj.androidfirstline.checpter7

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_write_file.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.StringBuilder

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/7
 * Description :
 */
class WriteFileAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_write_file)

        btn_save.setOnClickListener {
            val text = et_text.text.toString()

            saveTextToFile(text)
        }

        btn_read.setOnClickListener {
            readTv.text = readTextFromFile()
        }

        et_text.setText(readTextFromFile())
    }

    private fun readTextFromFile(): String{
        val content = StringBuilder()

        val input =  openFileInput("personalFile")
        val reader = BufferedReader(InputStreamReader(input))

        reader.use {
            reader.forEachLine {
                content.append(it)
            }
        }
        return content.toString()
    }

    private fun saveTextToFile(text: String) {
        //默认存储到/data/data/<package name>/file/
        val outPut = openFileOutput("personalFile", Context.MODE_APPEND)
        val writer = BufferedWriter(OutputStreamWriter(outPut))

        //use函数保证在Lambda表达式中的代码全部执行完之后自动将外层的流关闭
        writer.use {
            it.write(text)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val text = et_text.text.toString()
        saveTextToFile(text)
    }
}