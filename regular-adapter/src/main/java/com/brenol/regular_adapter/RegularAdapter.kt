package com.brenol.regular_adapter

import androidx.annotation.LayoutRes

class RegularAdapter<T> private constructor(
    @LayoutRes itemLayoutRes: Int,
    itemVarId: Int,
    items: List<T> = arrayListOf()
) : GenericRecyclerViewAdapter<T>(itemLayoutRes, itemVarId, items) {

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {

        val item = getItemForPosition(position)
        holder.binding.apply {
            setVariable(getItemVarId(position), item)
        }
    }

    companion object {
        fun <T> getAdapter(@LayoutRes itemLayoutRes: Int, itemVarId: Int, items: List<T> = arrayListOf(), onItemClickCallback: ((position: Int, item: T) -> Unit)? = null): RegularAdapter<T> {
           return RegularAdapter(itemLayoutRes, itemVarId, items).also {
               it.setOnItemClick { position, item ->
                   onItemClickCallback?.invoke(position, item)
               }
            }
        }
    }
}