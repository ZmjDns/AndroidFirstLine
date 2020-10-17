package com.zmj.androidfirstline.selfdefView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_sports_view.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/31
 * Description :
 */
class SportsView: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_sports_view)

        sportView.startAnimal()
        loading.startAnimator()
    }

}