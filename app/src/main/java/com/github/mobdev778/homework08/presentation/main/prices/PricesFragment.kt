package com.github.mobdev778.homework08.presentation.main.prices

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mobdev778.homework08.R
import com.github.mobdev778.homework08.databinding.FragmentPricesBinding

class PricesFragment : Fragment() {

    private var _binding: FragmentPricesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPricesBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with (binding) {
            wvPrices.settings.javaScriptEnabled = true
            wvPrices.clearCache(true)
            wvPrices.loadUrl(getString(R.string.prices_url))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

