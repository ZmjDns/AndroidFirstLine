package com.zmj.androidfirstline.coroutinelifecycle.data

import com.google.gson.annotations.SerializedName

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/28
 * Description :
 */

data class PlaceResponse(val status: String,val places: List<Place>)

data class Place(val name: String,
                 val location: Location,
                 @SerializedName("formatted_address") val address: String)

data class Location(val lng: String,val lat: String)