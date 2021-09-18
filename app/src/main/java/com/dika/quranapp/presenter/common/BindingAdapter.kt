package com.dika.quranapp.presenter.common

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("app:setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.adapter = adapter
    }
}

@BindingAdapter("app:showDivider")
fun RecyclerView.showDivider(show: Boolean) {
    val orientation = when (layoutManager) {
        is LinearLayoutManager -> (layoutManager as LinearLayoutManager).orientation
        is GridLayoutManager -> (layoutManager as GridLayoutManager).orientation
        else -> RecyclerView.VERTICAL
    }
    if (show) {
        addItemDecoration(DividerItemDecoration(context, orientation))
    } else {
        clearDecorations()
    }
}

fun RecyclerView.clearDecorations() {
    if (itemDecorationCount > 0) {
        for (i in itemDecorationCount - 1 downTo 0) {
            removeItemDecorationAt(i)
        }
    }
}
