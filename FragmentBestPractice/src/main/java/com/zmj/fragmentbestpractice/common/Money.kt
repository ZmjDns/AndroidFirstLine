package com.zmj.fragmentmodel.ui.common

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
/**
 * 运算符重载
 */
fun main() {
    val money1 = Money(5)
    val money2 = Money(10)
    val money3 = money1 + money2
    val money4 = money3 + 10
    println(money3.value)
    println(money4.value)
}
class Money (val value: Int){
    operator fun plus(money: Money): Money{
        val sum = value + money.value
        return Money(sum)
    }
    operator fun plus(mun: Int): Money{
        return Money(value + mun)
    }
}

/**
 * 借助扩展函数和运算符重载
 * 实现一个字符串重复倍数
 * 例如："absc" * 2 = "abscabsc"
 */
operator fun String.times(n:Int): String{
    val stringBuilder = StringBuilder()
    repeat(n){
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}