package com.tistory.blackjin.sample.base

import android.os.Bundle
import android.view.View
import com.tistory.blackjin.R
import com.tistory.blackjin.base.BaseFragment
import com.tistory.blackjin.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.ext.toast
import com.tistory.blackjin.sample.data.SampleData

class RecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    override var logTag = "RecyclerViewFragment"

    companion object {

        fun newInstance() = RecyclerViewFragment()
    }

    private val recyclerViewAdapter by lazy {
        RecyclerViewAdapter().apply {
            onItemClickListener = object :
                RecyclerViewAdapter.OnItemClickListener {
                override fun onItemClick(data: String) {
                    this@RecyclerViewFragment.requireContext().toast(data)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listSample) {
            adapter = recyclerViewAdapter
        }

        recyclerViewAdapter.replaceAll(SampleData.get("RecyclerViewFragment"))
    }
}