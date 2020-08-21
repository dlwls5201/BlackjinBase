package com.tistory.mybase.liverecyclerview

interface DiffComparable<T> {
    fun areItemsTheSame(item: T): Boolean
    fun areContentsTheSame(item: T): Boolean
}