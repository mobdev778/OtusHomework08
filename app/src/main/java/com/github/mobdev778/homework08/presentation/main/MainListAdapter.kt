package com.github.mobdev778.homework08.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mobdev778.homework08.databinding.ViewMainItemBinding
import com.github.mobdev778.homework08.domain.MainListItem

internal class MainListAdapter(
    private val items: List<MainListItem>
) : RecyclerView.Adapter<MainListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListItemHolder {
        val itemBinding = ViewMainItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainListItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainListItemHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}
