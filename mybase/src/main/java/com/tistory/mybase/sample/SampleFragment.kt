package com.tistory.mybase.sample

import android.os.Bundle
import android.view.View
import com.tistory.mybase.R
import com.tistory.mybase.base.BaseFragment
import com.tistory.mybase.databinding.FragmentSampleBinding
import com.tistory.mybase.ext.alert
import com.tistory.mybase.ext.toast
import com.tistory.mybase.listener.OnSingleClickListener

class SampleFragment : BaseFragment<FragmentSampleBinding>(R.layout.fragment_sample) {

    override var logTag = "SampleFragment"

    companion object {

        fun newInstance() = SampleFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnAlert.setOnClickListener {
                requireContext().alert(title = "BlackJin", message = "Welcome to my blog") {
                    positiveButton("ok") {
                        requireContext().toast("click the positive button")
                        //auto dismiss
                    }

                    negativeButton("cancel") {
                        //auto dismiss
                    }
                }.show()
            }

            var count = 0
            btnSingleClick.setOnClickListener(object : OnSingleClickListener(3000) {
                override fun onSingleClick(view: View) {
                    btnSingleClick.text = "${count++}"
                }
            })

            btnRecyclerView.setOnClickListener {
                (requireActivity() as SampleActivity).goToRecyclerViewFragment()
            }

            btnSimpleRecyclerView.setOnClickListener {
                (requireActivity() as SampleActivity).goToSimpleRecyclerViewFragment()
            }

            btnLiveRecyclerView.setOnClickListener {
                (requireActivity() as SampleActivity).goToLiveRecyclerViewFragment()
            }
        }
    }
}