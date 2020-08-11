package com.zmj.androidfirstline.common

import android.view.View

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */

fun main() {
    val num1 = 100
    val num2 = 800
    val result1 = number1AndNumber2(num1,num2,::plus)
    val result2 = number1AndNumber2(num1,num2,::minus)
    println("result1: $result1")
    println("result2:$result2")

    val result3 = number1AndNumber2(2,5){ n1,n2 ->
        n1 + n2
    }

    val list = listOf("Apple","banana","Gripe","Orange")
    val fruitStrBuild = StringBuilder().build {
        for(it in list) {
            append(it).append("\n")
        }
    }
    println("fruitStrBuild:${fruitStrBuild.toString()}")

    println("main Start")
    val str = ""
    printString(str){s ->
        println("Lambda start")
        if (s.isEmpty()) return
        println(s)
        println("Lambda end")
    }
    println("main end")
}

/**
 * @param operation 为函数类型的形参
 */
fun number1AndNumber2(num1: Int,num2: Int,operation:(Int,Int) -> Int): Int{
    val result = operation(num1,num2)

    return result
}

fun plus(num1: Int,num2: Int): Int{
    return num1 + num2
}

fun minus(num1: Int,num2: Int):Int{
    return num1 - num2
}

fun StringBuilder.build(block:StringBuilder.() -> Unit): StringBuilder{
    block()
    return this
}

/**
 * 内联函数声明
 * 以及内联的取消
 */
inline fun inlineTest(block1: () -> Unit,noinline block2: () -> Unit){

}

inline fun printString(str:String,block: (String) -> Unit){
    println("PrintString begin")
    block(str)
    println("PrintString end")
}

inline fun runRunnable(crossinline block: () -> Unit){
    val runnable = Runnable {
        block()
    }
    runnable.run()
}
