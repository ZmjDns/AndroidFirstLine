package com.zmj.androidfirstline.service

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/20
 * Description :
 */

open class Person(val name: String,val age: Int)
class Student(name: String,age: Int): Person(name, age)
class Teacher(name: String,age: Int): Person(name, age)

class SimpleData<out T/*,R*/>(val data: T/*,private var ss:R*/){
    fun get(): T{
        return data
    }

    /*fun getSec(): R{
        return ss
    }*/
}

fun main() {
    val student = Student("Tom",15)
    val teacher = Teacher("Kluz",36)
    val data = SimpleData<Person>(student)
    handleMyData(data)
    val studentData = data.get()
}
fun handleMyData(data: SimpleData<Person>){
    val personData = data.get()

}
