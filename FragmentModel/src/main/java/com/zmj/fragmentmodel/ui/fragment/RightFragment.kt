package com.zmj.fragmentmodel.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.zmj.fragmentmodel.R

/**
 *Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/5
 * Description :
 */
class RightFragment: Fragment(){

    companion object{
        const val TAG = "RightFragment"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d(TAG,"onAttach......")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate......")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"onCreateView......")
        return inflater.inflate(R.layout.fragment_right,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG,"onActivityCreated......")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart......")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume......")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause......")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop......")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG,"onDestroyView......")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy......")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"onDetach......")
    }
}