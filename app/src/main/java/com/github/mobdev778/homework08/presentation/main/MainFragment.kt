package com.github.mobdev778.homework08.presentation.main

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import com.github.mobdev778.homework08.R
import com.github.mobdev778.homework08.databinding.FragmentMainBinding
import com.github.mobdev778.homework08.domain.MainListItem

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private var adapter: MainListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun bindAdapter() {
        adapter = MainListAdapter(listOf(
            MainListItem.icon(R.drawable.agent_photo)
                .label(R.string.about_agent_title)
                .iconTransition(R.string.transition_about_agent_logo)
                .labelTransition(R.string.transition_about_agent_title)
                .action(R.id.action_MainFragment_to_AboutAgentFragment),

            MainListItem.icon(R.drawable.baseline_language_24)
                .label(R.string.tour_title)
                .iconTransition(R.string.transition_tour_logo)
                .labelTransition(R.string.transition_tour_title)
                .action(R.id.action_MainFragment_to_TourFragment),

            MainListItem.icon(R.drawable.baseline_calculate_24)
                .label(R.string.prices_title)
                .iconTransition(R.string.transition_prices_logo)
                .labelTransition(R.string.transition_prices_title)
                .action(R.id.action_MainFragment_to_PricesFragment),
        ))
        binding.rvMainList.adapter = adapter
    }

}
