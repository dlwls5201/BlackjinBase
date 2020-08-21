package com.tistory.mybase.sample.simple

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.tistory.mybase.BR
import com.tistory.mybase.R
import com.tistory.mybase.base.BaseFragment
import com.tistory.mybase.databinding.FragmentRecyclerViewBinding
import com.tistory.mybase.databinding.ItemSampleBinding
import com.tistory.mybase.ext.toast
import com.tistory.mybase.sample.data.SampleData
import com.tistory.mybase.simplerecyclerview.SimpleRecyclerViewAdapter
import com.tistory.mybase.simplerecyclerview.SimpleViewHolder

class SimpleRecyclerViewFragment :
    BaseFragment<FragmentRecyclerViewBinding>(R.layout.fragment_recycler_view) {

    override var logTag = "SimpleRecyclerViewFragment"

    companion object {

        fun newInstance() = SimpleRecyclerViewFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.listSample) {
            adapter = object : SimpleRecyclerViewAdapter<String, ItemSampleBinding>(
                R.layout.item_sample,
                BR.model
            ) {
                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): SimpleViewHolder<ItemSampleBinding> {
                    return super.onCreateViewHolder(parent, viewType).apply {
                        itemView.setOnClickListener {
                            val data = getItem(adapterPosition)
                            this@SimpleRecyclerViewFragment.requireContext().toast(data)
                        }
                    }
                }
            }.apply {
                replaceAll(SampleData.get("SimpleRecyclerViewFragment"))
            }
        }
    }
}