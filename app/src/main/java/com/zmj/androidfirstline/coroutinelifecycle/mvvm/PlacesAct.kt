package com.zmj.androidfirstline.coroutinelifecycle.mvvm

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.*
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_places.*
import kotlinx.coroutines.launch

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/28
 * Description :
 */
class PlacesAct: AppCompatActivity() {

    private val placesViewModel by lazy {
        //ViewModelProviders.of(this).get(PlacesViewModel::class.java)      过时Api
        ViewModelProvider.NewInstanceFactory().create(PlacesViewModel::class.java)
    }

    private lateinit var placeStr: StringBuilder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_places)

        /*btn_search.setOnClickListener {
            val query = et_place.text.toString()
            if (query.isNotEmpty()){
                placesViewModel.searchPlace(query)
            }
        }*/

        placeStr = StringBuilder()

        initPlaceObserver()

        initSearchEdit()

        //直接在Act中开启协程
        lifecycleScope.launch {

        }
    }

    init {
        //在act created之后调用
        lifecycleScope.launchWhenCreated {

        }
    }

    private fun initSearchEdit() {
        et_place.addTextChangedListener { text: Editable? ->
            val content = text.toString()
            if (content.isNotEmpty()){
                placesViewModel.searchPlace(content)
            }
        }
    }

    private fun initPlaceObserver(){
        placesViewModel.observablePlaces.observe(this, Observer {result ->
            Log.d("PlacesAct","net call back......")
            val response = result.getOrNull()
            val placeList = response?.places ?: return@Observer
            placesViewModel.searchedPlaces.clear()
            placesViewModel.searchedPlaces.addAll(placeList)
            for (place in placeList){
                placeStr.append(place.name + place.address + "\n")
            }
            tv_places.text = placeStr.toString()
        })
    }
}