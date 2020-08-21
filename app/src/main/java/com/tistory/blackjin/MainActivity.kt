package com.tistory.blackjin

import android.content.Intent
import android.os.Bundle
import com.tistory.blackjin.base.BaseActivity
import com.tistory.blackjin.databinding.ActivityMainBinding
import com.tistory.blackjin.sample.SampleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override var logTag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        button.setOnClickListener {
            startActivity(
                Intent(this, SampleActivity::class.java)
            )
        }
    }
}