package com.zmj.androidfirstline.checpter7

import android.content.Context
import android.os.Environment
import com.zmj.androidfirstline.App
import java.io.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/14
 * Description :
 */
/**
 * 往文件中写入数据
 */
fun writeData2File(str: String){
    val output = App.appContext.openFileOutput("localData",Context.MODE_PRIVATE)
    val writer = BufferedWriter(OutputStreamWriter(output))
    writer.use {
        it.write(str)
    }
}

/**
 * 从文件中读数据
 */
//@Throws(FileNotFoundException::class)
fun readDataFromFile(): String{
    val content = StringBuilder()
    try {
        val input = App.appContext.openFileInput("localData")
        val reader = BufferedReader(InputStreamReader(input))
        reader.use {
            reader.forEachLine {
                content.append(it)
            }
        }
    }catch (e: Exception){
        e.printStackTrace()
    }

    return content.toString()
}

/**
 * 判断外部存储空间是否可以写入
 */
fun isExternalStorageWritable(): Boolean{
    return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
}

/**
 * 判断外部存储空间至少可以读
 */
fun isExternalStorageReadable(): Boolean{
    return Environment.getExternalStorageState() in setOf(Environment.MEDIA_MOUNTED,Environment.MEDIA_MOUNTED_READ_ONLY)
}

