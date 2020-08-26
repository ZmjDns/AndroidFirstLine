package com.zmj.androidfirstline.checpter7

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.storage.StorageManager
import android.os.storage.StorageManager.ACTION_MANAGE_STORAGE
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import com.zmj.androidfirstline.App
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

        //dataBase()
        externalStorageVolumes()
    }

    fun externalStorageVolumes(){
        val externalStorageList = ContextCompat.getExternalFilesDirs(App.appContext,null)
        //返回数组中第一个元素被视为主外部存储卷，除非该卷已满或不可使用，否则请使用该卷
        //      /storage/emulated/0/Android/data/com.zmj.androidfirstline/files
        val mainContainerStorage = externalStorageList[0]
        Log.d("WriteFileAct","getExternalFilesDirs[0]： ${mainContainerStorage.path}")

        val cacheDirList = ContextCompat.getExternalCacheDirs(App.appContext)
        val cacheDir = cacheDirList[0]
        Log.d("WriteFileAct","getExternalCacheDirs[0]： ${cacheDir.path}")

        val contextCacheDir = App.appContext.cacheDir
        Log.d("WriteFileAct","contextCacheDir： ${contextCacheDir.path}")

        val contextFilesDir = App.appContext.filesDir
        Log.d("WriteFileAct","contextFilesDir： ${contextFilesDir.path}")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAvailableSizeFromSystem(){
        val NUM_BYTES_MEED_FOR_MY_APP = 1024 * 1024 * 10L

        val storageManager = App.appContext.getSystemService(Context.STORAGE_SERVICE) as StorageManager
        val specrifiedInternalDirUuid = storageManager.getUuidForPath(filesDir)
        val availabBytes = storageManager.getAllocatableBytes(specrifiedInternalDirUuid)
        if (availabBytes >= NUM_BYTES_MEED_FOR_MY_APP){
            storageManager.allocateBytes(specrifiedInternalDirUuid,NUM_BYTES_MEED_FOR_MY_APP)
        }else{
            val storageIntent = Intent().apply {
                action = ACTION_MANAGE_STORAGE
            }
        }
    }


    private fun readTextFromFile(): String{
        /*val content = StringBuilder()

        val input =  openFileInput("personalFile")
        val reader = BufferedReader(InputStreamReader(input))

        reader.use {
            reader.forEachLine {
                content.append(it)
            }
        }
        return content.toString()*/

        return readDataFromFile()
    }

    private fun saveTextToFile(text: String) {
        /*//默认存储到/data/data/<package name>/file/
        val outPut = openFileOutput("personalFile", Context.MODE_APPEND)
        val writer = BufferedWriter(OutputStreamWriter(outPut))

        //use函数保证在Lambda表达式中的代码全部执行完之后自动将外层的流关闭
        writer.use {
            it.write(text)
        }*/

        writeData2File(text)
    }


















    fun dataBase(){
        val db = DataBaseHelper()
        db.writableDatabase

        //insertData()
        //updateData()

        queryData()
    }

    fun insertData(){
        val db = DataBaseHelper().writableDatabase
        val contentValues1 = ContentValues().apply {
            put("name","The Da Vinci Code")
            put("author","TDVC")
            put("pages",1200)
            put("price",19.95)
        }
        db.insert("Book",null,contentValues1)

        val contentValues2 = ContentValues().apply {
            put("name","The Lost Symbol")
            put("author","TLS")
            put("pages",960)
            put("price",20)
        }
        db.insert("Book",null,contentValues2)
    }

    fun updateData(){
        val db = DataBaseHelper().writableDatabase
        val contentValues = ContentValues().apply {
            put("price",100)
        }
        db.update("Book",contentValues,"name=?", arrayOf("The Lost Symbol"))
    }

    fun queryData(){
        val db = DataBaseHelper().readableDatabase
        val cursor = db.query("Book", null,null,null,null,null,null)
        /*val cursor = db.rawQuery("select * from Book",null)
        val count = cursor.count
        for (position in 0 until count){
            cursor.move(position)
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val price = cursor.getFloat(cursor.getColumnIndex("author"))
            Log.d("WriteFileAct","name: $name  price: $price")
        }*/
        do {
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val price = cursor.getFloat(cursor.getColumnIndex("author"))
            Log.d("WriteFileAct","name: $name  price: $price")
        }while (cursor.moveToNext())

        cursor.close()
    }

    fun sharedPreferenceExt(){
        getSharedPreferences("aa",Context.MODE_PRIVATE).open {
            putString("aaaa","sad")
            putInt("int",5555)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        val text = et_text.text.toString()
        saveTextToFile(text)
    }
}