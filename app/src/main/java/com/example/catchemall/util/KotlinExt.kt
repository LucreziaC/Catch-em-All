package com.example.catchemall.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val <T> T.exhaustive: T
    get() = this

fun RecyclerView?.getCurrentPosition() : Int {
    return (this?.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
}