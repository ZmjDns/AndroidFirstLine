package com.zmj.androidfirstline.checpter7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.zmj.androidfirstline.App
import com.zmj.androidfirstline.common.showToast

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/14
 * Description :
 */
class DataBaseHelper: SQLiteOpenHelper(App.appContext,"BookStore.db",null,2) {

    private val bookCreator = "create table Book(id integer primary key," +
            "author text,price real,pages integer,name text)"

    private val categoryCreator = "create table Category(id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(bookCreator)
        db?.execSQL(categoryCreator)
        showToast("创建Book、Category完成")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Book")
        db?.execSQL("drop table if exists Category")
        onCreate(db)
    }
}