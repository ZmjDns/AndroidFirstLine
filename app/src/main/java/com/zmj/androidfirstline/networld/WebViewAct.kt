package com.zmj.androidfirstline.networld

import android.content.Intent
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_webview.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/27
 * Description :
 */
class WebViewAct: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_webview)

        webView.settings.javaScriptEnabled = true
        //当需要从一个网页跳转到另一个网页时，我们希望目标网页任然处于当前WebView中，而不是跳转到浏览器
        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://www.jbr720.com/putout/vrpano41/")

        //sendHttpUrlConnection()

        okhttp.setOnClickListener {
            startActivity(Intent(this,ActOkhttpTest::class.java))
        }
    }


    fun sendHttpUrlConnection(){
        thread {
            var connection: HttpURLConnection? = null
            try {
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection

                connection.connectTimeout = 8000
                connection.readTimeout = 8000

                val input = connection.inputStream
                val strBuilder = StringBuilder()

                val bufferReader = BufferedReader(InputStreamReader(input))
                /*bufferReader.forEachLine {
                    strBuilder.append(it)
                }*/

                bufferReader.use {
                    bufferReader.forEachLine {
                        strBuilder.append(it)
                    }

                    showResponse(strBuilder.toString())
                }

            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                connection?.disconnect()
            }
        }
    }

    private fun showResponse(string: String) {
        runOnUiThread {
            text.text = string
        }
    }
}