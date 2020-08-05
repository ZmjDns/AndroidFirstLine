package com.zmj.androidfirstline.common

import com.zmj.androidfirstline.model.Msg

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
/**
 * 密封类
 * 单独处于同一个文件的顶层位置，不能嵌套在其他类中
 */
sealed class Result
class Success(val msg: Msg): Result()
class Failure(val error:Exception): Result()

fun getResultMsg(result: Result) = when(result){
    is Success -> result.msg
    is Failure -> "Error is ${result.error}"
}