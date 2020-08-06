package com.zmj.fragmentmodel.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.zmj.fragmentmodel.R
import com.zmj.fragmentmodel.ui.fragment.AnotherFragment
import com.zmj.fragmentmodel.ui.fragment.RightFragment
import kotlinx.android.synthetic.main.fragment_left.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openAnother.setOnClickListener {
            switchFragment(AnotherFragment())
        }

        switchFragment(RightFragment())
    }

    fun switchFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightCon,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}