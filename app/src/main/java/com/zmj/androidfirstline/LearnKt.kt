package com.zmj.androidfirstline

import java.util.*
import kotlin.collections.HashMap

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/4
 * Description :
 */

data class CellPhone(val name: String,val price: Float)

fun main(){
    println("hello Kt")

    val cellPhone1 = CellPhone("ss",199.2f)
    val cellPhone2 = CellPhone("ss",199.2f)

    println("equals: ${cellPhone1==cellPhone2}")

    //jiHe()

    lambdaTest()
}

fun jiHe(){
    //不可变集合
    val list = listOf("sss","ssss")

    val mutableList = mutableListOf("sads","dsafdd")
    mutableList.add("vnshusdbv")

    //与list集合不同，set集合底层使用hash映射机制存放数据，不能保证数据的有序性
    val set = setOf("njicans","bcsabfahfi")
    val mutableSet = mutableSetOf("csuisha","huaihswdwwd")
    mutableSet.add("ncijasnfsef")

    val map = HashMap<String,String>()
    map["cskcmk"] = "ciasci"
    val mutableMap = mutableMapOf("cnishcd" to 1,"uwihfuie" to 1,"hdiwhdiw" to 3)

    for ((name,value) in mutableMap){
        println("$name namber is $value")
    }
}

fun lambdaTest(){
    val list = mutableListOf("Apple","Banana","Orange","Pear","Grape","Watermelon")

    //println("maxLength: ${list.maxBy { it.length }}")
    val lambda = {fruit: String -> fruit.length }
    val maxLengthFruit = list.maxBy(lambda)

    val maxLengthFruit1 = list.maxBy{it.length }

    //val upperCaseList = list.map { it.toUpperCase(Locale.ROOT) }
    val upperCaseList = list.map{it.toUpperCase(Locale.ROOT) }

    for (fruit in upperCaseList){
        println(fruit)
    }

    val filterList = list.filter { it.length <= 5 }.map { it.toUpperCase(Locale.ROOT) }
    for (fruit in filterList){
        println("fliter: $fruit")
    }

    val anyResult = list.any {it.length > 5 }
    val allResult = list.all { it.length < 5 }

    println("anyResult: $anyResult   allResult: $allResult")

    Thread{
        println()
    }

}

