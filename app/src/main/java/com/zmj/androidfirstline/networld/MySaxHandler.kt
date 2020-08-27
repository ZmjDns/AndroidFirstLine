package com.zmj.androidfirstline.networld

import android.util.Log
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/27
 * Description :
 */
class MySaxHandler: DefaultHandler() {

    private var nodeName = ""

    private lateinit var id: StringBuilder
    private lateinit var name: StringBuilder
    private lateinit var version: StringBuilder

    override fun startDocument() {
        Log.d("MySaxHandler","startDocument........")
        id = StringBuilder()
        name = StringBuilder()
        version = StringBuilder()
    }

    override fun startElement(uri: String?, localName: String, qName: String?, attributes: Attributes?) {
        //记录当前节点名
        nodeName = localName
        Log.d("MySaxHandler","uri is $uri")
        Log.d("MySaxHandler","localName is $localName")
        Log.d("MySaxHandler","qName is $qName")
        Log.d("MySaxHandler","attributes is $attributes")
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        Log.d("MySaxHandler","characters ——>ch: $ch    start: $start    length: $length")
        //根据节点名将内容添加到对应的数据中
        when(nodeName){
            "id" -> id.append(ch,start,length)
            "name" -> name.append(ch,start,length)
            "version" -> version.append(ch,start,length)
        }
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        Log.d("MySaxHandler","endElement -> uri is $uri  localName is $localName  qName is $qName ")
        if ("app" == localName){
            Log.d("MySaxHandler","id is ${id.toString().trim()}")
            Log.d("MySaxHandler","name is ${name.toString().trim()}")
            Log.d("MySaxHandler","version is ${version.toString().trim()}")
            //每个app解析完之后要将StingBuilder情空
            id.setLength(0)
            name.setLength(0)
            version.setLength(0)
        }
    }

    override fun endDocument() {

        Log.d("MySaxHandler","endDocument........")
    }
}