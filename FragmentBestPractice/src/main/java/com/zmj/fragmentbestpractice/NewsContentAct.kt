package com.zmj.fragmentbestpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zmj.fragmentbestpractice.fragment.NewsContentFragment
import com.zmj.fragmentmodel.R
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentAct : AppCompatActivity() {

    companion object{
        fun actionStart(context: Context,title: String,content: String){
            val intent = Intent(context,NewsContentAct::class.java).apply {
                putExtra("news_title",title)
                putExtra("news_content",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)

        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")

        if (title != null && content != null){
            val fragment = fragment_newsContent as NewsContentFragment
            fragment.refresh(title,content)
        }
    }
}