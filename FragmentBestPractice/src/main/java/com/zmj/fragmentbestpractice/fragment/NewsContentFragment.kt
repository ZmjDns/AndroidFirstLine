package com.zmj.fragmentbestpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zmj.fragmentmodel.R
import kotlinx.android.synthetic.main.fragment_news_content.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
class NewsContentFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_content,container,false)
        return view
    }

    fun refresh(title: String,content: String){
        newsTitle.text = title
        newsContent.text = content
        contentLayout.visibility = View.VISIBLE
    }
}