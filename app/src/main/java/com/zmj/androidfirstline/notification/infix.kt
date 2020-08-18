package com.zmj.androidfirstline.notification

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/18
 * Description :
 */

infix fun String.beginWith(str: String) = startsWith(str)

infix fun <T> Collection<T>.has(string: T) = contains(string)
//类似map中的to（）函数
infix fun <D,F> D.with(f: F): Pair<D,F> = Pair(this,f)


fun main() {
    if ("aaa" beginWith "a"){
        println("aaa begin with a")
    }

    val list = listOf("aaa","bbbb","cccc")

    if (list has "bbbb"){
        println("list has bbbb")
    }

    val ss = mapOf(1 to "ss")

    val ssss = mapOf("sss" with 2)

}