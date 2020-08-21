package com.tistory.mybase.sample

import android.os.Bundle
import com.tistory.mybase.R
import com.tistory.mybase.base.BaseActivity
import com.tistory.mybase.databinding.ActivitySampleBinding
import com.tistory.mybase.sample.base.RecyclerViewFragment
import com.tistory.mybase.sample.live.LiveRecyclerViewFragment
import com.tistory.mybase.sample.simple.SimpleRecyclerViewFragment

class SampleActivity : BaseActivity<ActivitySampleBinding>(R.layout.activity_sample) {

    override var logTag = "SampleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.lyt_sample_container, SampleFragment.newInstance())
            .commit()
    }

    fun goToRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, RecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun goToSimpleRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, SimpleRecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    fun goToLiveRecyclerViewFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.lyt_sample_container, LiveRecyclerViewFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
