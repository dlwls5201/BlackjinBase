package com.tistory.blackjin.sample.live

import android.os.Bundle
import android.view.View
import com.tistory.blackjin.R
import com.tistory.blackjin.base.BaseFragment
import com.tistory.blackjin.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.ext.toast
import com.tistory.blackjin.liverecyclerview.bindData
import com.tistory.blackjin.sample.data.SampleData

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