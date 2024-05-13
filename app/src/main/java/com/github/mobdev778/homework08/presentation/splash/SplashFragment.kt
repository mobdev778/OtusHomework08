package com.github.mobdev778.homework08.presentation.splash

import android.animation.AnimatorInflater
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.github.mobdev778.homework08.R
import com.github.mobdev778.homework08.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                AnimatorInflater.loadAnimator(context, R.animator.splash_logo_anim)
                    .apply {
                        setTarget(binding.ivSarmatLogo)
                        start()
                    }

                delay(SPLASH_ANIMATION_DURATION)
                val extras = FragmentNavigatorExtras(
                    binding.ivSarmatLogo to getString(R.string.transition_sarmat_logo),
                    binding.tvSarmatTitle to getString(R.string.transition_sarmat_title))
                findNavController().navigate(
                    R.id.action_SplashFragment_to_MainFragment,
                    null,
                    null,
                    extras
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val SPLASH_ANIMATION_DURATION = 2000L
    }
}
