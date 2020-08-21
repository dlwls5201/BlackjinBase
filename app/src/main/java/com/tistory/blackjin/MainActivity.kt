package com.tistory.blackjin

import android.os.Bundle
import com.tistory.blackjin.databinding.ActivityMainBinding
import com.tistory.mybase.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override var logTag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}