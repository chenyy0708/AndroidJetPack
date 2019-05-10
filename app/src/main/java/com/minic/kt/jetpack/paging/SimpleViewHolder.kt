package com.minic.kt.jetpack.paging

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


/**
 * @ClassName: SimpleViewHolder
 * @Description:通用ViewHolder
 * @Author: ChenYy
 * @Date: 2019-05-09 09:29
 */
class SimpleViewHolder(parent: ViewGroup, @LayoutRes layoutId: Int) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, false)) {

    private var mSparseArray: SparseArray<View>? = null

    init {
        mSparseArray = SparseArray()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : View> getView(@IdRes viewId: Int): T {
        var view = mSparseArray?.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            mSparseArray?.put(viewId, view)
        }
        return view as T
    }

    fun setText(@IdRes viewId: Int, str: String?): SimpleViewHolder {
        getView<TextView>(viewId).text = str
        return this
    }

    fun loadIV(@IdRes viewId: Int, str: String?): SimpleViewHolder {
        return this
    }
}