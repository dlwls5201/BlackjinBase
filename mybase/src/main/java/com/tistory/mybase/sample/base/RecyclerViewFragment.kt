package com.tistory.mybase.sample.base

import android.os.Bundle
import android.view.View
import com.tistory.mybase.R
import com.tistory.mybase.base.BaseFragment
import com.tistory.mybase.databinding.FragmentRecyclerViewBinding
import com.tistory.mybase.ext.toast
import com.tistory.mybase.sample.data.SampleData

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