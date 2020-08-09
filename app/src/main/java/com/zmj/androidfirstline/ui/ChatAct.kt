package com.zmj.androidfirstline.ui

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zmj.androidfirstline.R
import com.zmj.androidfirstline.model.Msg
import com.zmj.androidfirstline.ui.adapter.ChatAdapter
//import com.zmj.permissionx.PermissionX
import kotlinx.android.synthetic.main.act_chat.*

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
class ChatAct: AppCompatActivity() {

    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_chat)

        supportActionBar?.hide()

        /*PermissionX.request(this,Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE){allGranted,deniedList ->
            if (allGranted){
                Toast.makeText(this,"申请权限成功",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"You denied $deniedList",Toast.LENGTH_SHORT).show()
            }
        }*/
        initMsg()

        if (!::adapter.isInitialized){
            adapter = ChatAdapter(msgList)
        }

        recycler.adapter = adapter

        btn_send.setOnClickListener {
            val content = et_text.text.toString()
            if (content.isNotEmpty()){
                val msg = Msg(content,Msg.TYPE_SEND)
                msgList.add(msg)
                adapter.notifyItemInserted(msgList.size - 1)    //有新消息
                //刷新recyclerView中的显示
                recycler.scrollToPosition(msgList.size - 1)
                et_text.setText("")
            }
        }
    }

    private fun initMsg(){
        msgList.add(Msg("Hello guy",Msg.TYPE_RECEIVED))
        msgList.add(Msg("Hello who is that?",Msg.TYPE_SEND))
        msgList.add(Msg("This is Tom,nice talking to you!",Msg.TYPE_RECEIVED))
    }


}