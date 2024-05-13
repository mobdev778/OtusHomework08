package com.github.mobdev778.homework08.presentation.main.tour

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mobdev778.homework08.R
import com.github.mobdev778.homework08.databinding.FragmentTourBinding

class TourFragment : Fragment() {

    private var _binding: FragmentTourBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTourBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding) {
            wvTour.settings.javaScriptEnabled = true
            wvTour.clearCache(true)
            wvTour.loadUrl(getString(R.string.tour_url))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
