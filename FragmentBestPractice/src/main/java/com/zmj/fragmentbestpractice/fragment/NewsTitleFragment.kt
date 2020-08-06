package com.zmj.fragmentbestpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.zmj.fragmentbestpractice.NewsContentAct
import com.zmj.fragmentbestpractice.model.News
import com.zmj.fragmentmodel.R
import com.zmj.fragmentmodel.ui.common.times
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_news_title.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/6
 * Description :
 */
class NewsTitleFragment: Fragment() {

    private var isTwoPane = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_title,container,false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //获取宿主activity中是否有NewsContent布局，如果有的话就是twoPane
        isTwoPane = activity?.findViewById<View>(R.id.contentLayout) != null

        //填充数据
        val data = getNews()
        newsTitleRecycler.adapter = NewsAdapter(data)

    }

    private fun getNews(): List<News>{
        val newsList = ArrayList<News>()

        for (i in 0..50){
            newsList.add(News("This is News $i",getRandomLengthContent("This is news content $i")))
        }
        return newsList
    }

    private fun getRandomLengthContent(str: String): String{
        val n = (1..20).random()
        /*val strBuild = StringBuilder()
        repeat(n){
            strBuild.append(str)
        }

        return strBuild.toString()*/

        return str * n
    }


    inner class NewsAdapter(val newsList: List<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
        inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
            val holder = ViewHolder(view)

            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPane){
                    //双页
                    val fragment = newsContentFragment as NewsContentFragment
                    fragment.refresh(news.title,news.content)
                }else{
                    //单页
                    NewsContentAct.actionStart(parent.context,news.title,news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }
        override fun getItemCount() = newsList.size
    }

}