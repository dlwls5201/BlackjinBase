package com.tistory.mybase.sample.live

import android.os.Bundle
import android.view.View
import com.tistory.mybase.R
import com.tistory.mybase.base.BaseFragment
import com.tistory.mybase.databinding.FragmentRecyclerViewBinding
import com.tistory.mybase.ext.toast
import com.tistory.mybase.liverecyclerview.bindData
import com.tistory.mybase.sample.data.SampleData

class LiveRecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    override var logTag = "LiveRecyclerViewFragment"

    companion object {

        fun newInstance() = LiveRecyclerViewFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listSample.bindData(
            SampleData.get("LiveRecyclerViewFragment"),
            R.layout.item_sample,
            viewLifecycleOwner
        ) {
            requireContext().toast(it)
        }
    }
}