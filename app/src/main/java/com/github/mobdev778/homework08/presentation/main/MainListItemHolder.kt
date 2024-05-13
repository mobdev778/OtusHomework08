package com.github.mobdev778.homework08.presentation.main

import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.github.mobdev778.homework08.databinding.ViewMainItemBinding
import com.github.mobdev778.homework08.domain.MainListItem

internal class MainListItemHolder(
    private val itemBinding: ViewMainItemBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: MainListItem) {
        itemBinding.ivItemLogo.setImageResource(item.iconId)
        itemBinding.ivItemLogo.transitionName = itemView.resources.getString(item.iconTransitionId)

        itemBinding.tvItemTitle.setText(item.labelId)
        itemBinding.tvItemTitle.transitionName = itemView.resources.getString(item.labelTransitionId)

        itemBinding.root.setOnClickListener {
            it.findNavController().navigate(item.actionId)
        }
    }
}
