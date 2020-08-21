package com.tistory.blackjin.sample.simple

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.tistory.blackjin.BR
import com.tistory.blackjin.R
import com.tistory.blackjin.base.BaseFragment
import com.tistory.blackjin.databinding.FragmentRecyclerViewBinding
import com.tistory.blackjin.databinding.ItemSampleBinding
import com.tistory.blackjin.ext.toast
import com.tistory.blackjin.sample.data.SampleData
import com.tistory.blackjin.simplerecyclerview.SimpleRecyclerViewAdapter
import com.tistory.blackjin.simplerecyclerview.SimpleViewHolder

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