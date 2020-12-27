package com.tistory.blackjinbase.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tistory.blackjinbase.liverecyclerview.bindData


@BindingAdapter("itemList", "itemLayoutId")
fun <VM : Any> RecyclerView.bindAdapterData(
    itemList: List<VM>?,
    layoutId: Int
) {
    bindData(itemList, layoutId, null)
}