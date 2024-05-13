package com.github.mobdev778.homework08.presentation.main.about

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mobdev778.homework08.databinding.FragmentAboutAgentBinding

class AboutAgentFragment : Fragment() {

    private var _binding: FragmentAboutAgentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutAgentBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val duration = 500L
        with (binding) {
            ivAboutAgentPhone.animate().alpha(1.0f).setDuration(duration).start()
            tvAboutAgentPhone.animate().alpha(1.0f).setDuration(duration).start()
            ivAboutAgentEmail.animate().alpha(1.0f).setDuration(duration).start()
            tvAboutAgentEmail.animate().alpha(1.0f).setDuration(duration).start()
            ivAboutAgentTg.animate().alpha(1.0f).setDuration(duration).start()
            tvAboutAgentTg.animate().alpha(1.0f).setDuration(duration).start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
