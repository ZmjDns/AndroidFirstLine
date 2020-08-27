package com.zmj.androidfirstline.networld

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_okhttp_test.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/27
 * Description :
 */
class ActOkhttpTest: AppCompatActivity() {

    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_okhttp_test)

        okHttpClient = OkHttpClient()

        sendOkHttpSync()

        sendOkhtttpPost()

        //parseXMLWithPull()
        parseXmlWithSAX()
    }

    fun sendOkHttpSync(){
        thread {
            val request = Request.Builder()
                .url("https://www.baidu.com")
                .build()

            val response = okHttpClient.newCall(request).execute()

            val body = response.body()?.string()

            runOnUiThread {
                tv_show.text = body
            }
        }
    }

    fun sendOkhtttpPost(){
        thread {
            val requestBody = FormBody.Builder()
                .add("action","authentic")
                .add("author","云科世讯")
                .build()

            val request = Request.Builder()
                .url("http:123.206.55.106:9000/YYApi/")
                .post(requestBody)
                .build()

            val response = okHttpClient.newCall(request).execute()

            val body = response.body()?.string()

            runOnUiThread {
                postTv.text = body
            }
        }
    }


    fun parseXMLWithPull(){
        val data = readDataFromRaw() ?: return

        try {
            val factory = XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(data))
            var eventType = xmlPullParser.eventType
            var id = ""
            var name = ""
            var version = ""

            while (eventType != XmlPullParser.END_DOCUMENT){
                val nodeName = xmlPullParser.name
                when(eventType){
                    //开始的某个节点
                    XmlPullParser.START_TAG ->{
                        when(nodeName){
                            "id" -> id = xmlPullParser.nextText()
                            "name" -> name = xmlPullParser.nextText()
                            "version" -> version = xmlPullParser.nextText()
                        }
                    }
                    //完成解析某个节点
                    XmlPullParser.END_TAG -> {
                        if ("app" == nodeName){
                            Log.d("ActOkhttpTest","id is $id")
                            Log.d("ActOkhttpTest","name is $name")
                            Log.d("ActOkhttpTest","version is $version")
                        }
                    }
                }
                eventType = xmlPullParser.next()
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    fun parseXmlWithSAX(){
        val data = readDataFromRaw() ?: return
        try {
            val factory = SAXParserFactory.newInstance()
            val xmlReader = factory.newSAXParser().xmlReader
            val handler = MySaxHandler()
            //将handler设置到xmlReader中
            xmlReader.contentHandler = handler
            //开始解析
            xmlReader.parse(InputSource(StringReader(data)))
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
    fun readDataFromRaw(): String?{
        try {
            val input = resources.openRawResource(R.raw.get_data)
            val reader = BufferedReader(InputStreamReader(input))

            val strBuilder = StringBuilder()

            reader.use {
                reader.forEachLine {
                    strBuilder.append(it)
                }
            }

            return strBuilder.toString()
        }catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }
}