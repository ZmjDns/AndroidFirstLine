package com.zmj.androidfirstline.genericityanddelegent

import android.app.Dialog
import kotlin.reflect.KProperty

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/17
 * Description :
 */

//泛型
class MyClass<T> {

    fun param(param:T): T{
        return param
    }

    fun <R>paramGeneric(param: R): R{
        return param
    }
}


//委托类
class MySet<T>(val helperSet: HashSet<T>) : Set<T>{

    override val size: Int
        get() = helperSet.size

    override fun contains(element: T) = helperSet.contains(element)

    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)

    override fun isEmpty() = helperSet.isEmpty()

    override fun iterator() = helperSet.iterator()
}
//等价于
class MySetNew<T>(val helperSet: HashSet<T>): Set<T> by helperSet{

}

//委托属性
class MyClassD{
    var p by Delegate()
}
class Delegate{
    var propValue: Any? = null

    operator fun getValue(myClass: MyClassD,prop: KProperty<*>): Any?{
        return propValue
    }
    operator fun setValue(myClass: MyClassD,prop: KProperty<*>,value: Any?){
        propValue = value
    }
}





fun main() {
    val myClass = MyClass<Int>()
    val result2 = myClass.paramGeneric("ss")
    println(result2)
}