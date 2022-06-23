package com.brenol.regular_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class GenericRecyclerViewAdapter<T>(
    @LayoutRes private var itemLayout: Int,
    private var itemVarId: Int,
    var items: List<T> = arrayListOf()
) : RecyclerView.Adapter<GenericViewHolder>() {

    var onItemClickCallback: ((position: Int, item: T) -> Unit)? = null

    fun setOnItemClick(onItemClick: (position: Int, item: T) -> Unit) {
        this.onItemClickCallback = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )

        return GenericViewHolder(binding).also { viewHolder ->
            binding.root.apply {
                setOnClickListener {
                    onItemClickCallback?.invoke(
                        viewHolder.adapterPosition,
                        items[viewHolder.adapterPosition]
                    )
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return getItemForPosition(position).run {
            when {
                itemLayout != 0 -> itemLayout
                else -> {
                    throw IllegalArgumentException("Informe explicitamente o layout do item no constructor")
                }
            }
        }
    }

    protected fun getItemVarId(position: Int): Int {
        return getItemForPosition(position).run {
            when {
                itemVarId != 0 -> itemVarId
                else -> {
                    throw IllegalArgumentException("Informe explicitamente o id da variavel do item no constructor")
                }
            }
        }
    }


    override fun getItemCount(): Int = items.size

    protected fun getItemForPosition(position: Int) = items[position]

    fun addAll(items: List<T>) {
        val startPosition = itemCount

        this.items = ArrayList(this.items)
            .apply { addAll(items) }

        notifyItemRangeInserted(startPosition, items.size)
    }

    fun addItem(item: T) {
        items = ArrayList<T>(items)
            .apply { add(item) }

        notifyItemInserted(itemCount - 1)
    }

    fun addItem(index: Int, item: T) {
        items = ArrayList<T>(items)
            .apply { add(index, item) }

        notifyItemInserted(index)
    }

    fun removeItem(item: T) {
        removeItem(items.indexOfFirst { it == item })
    }

    fun removeItem(position: Int) {
        position.takeIf { it in 0 until itemCount }
            ?.let {
                items = ArrayList<T>(items)
                    .apply { removeAt(it) }

                notifyItemRemoved(it)
            }
    }

    fun clear() {
        items = arrayListOf()
        notifyDataSetChanged()
    }
}