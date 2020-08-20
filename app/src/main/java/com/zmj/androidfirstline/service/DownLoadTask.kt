package com.zmj.androidfirstline.service

import android.os.AsyncTask

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/20
 * Description :
 */
class DownLoadTask: AsyncTask<Unit,Int,Boolean>() {


    override fun onPreExecute() {
        super.onPreExecute()
    }


    override fun doInBackground(vararg params: Unit?): Boolean {


        return false
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Boolean?) {
        super.onPostExecute(result)
    }
}