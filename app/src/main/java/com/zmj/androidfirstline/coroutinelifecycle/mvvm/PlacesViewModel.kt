package com.zmj.androidfirstline.coroutinelifecycle.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zmj.androidfirstline.coroutinelifecycle.Repository
import com.zmj.androidfirstline.coroutinelifecycle.data.Place
import com.zmj.androidfirstline.coroutinelifecycle.data.PlaceResponse

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/28
 * Description :
 */
class PlacesViewModel: ViewModel() {

    private val placeName = MutableLiveData<String>()

    fun searchPlace(query: String){
        placeName.value = query
    }
    val observablePlaces = Transformations.switchMap(placeName){query ->
        Repository.getPlaces(query)
    }
    var searchedPlaces = ArrayList<Place>()
}