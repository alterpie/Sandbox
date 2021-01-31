package com.test.transferwise.feature.characters.presentation.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.test.transferwise.core.ui.BaseFragment
import com.test.transferwise.feature.characters.databinding.CharactersFragmentDetailsBinding

class CharacterDetailsFragment : BaseFragment<CharactersFragmentDetailsBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): CharactersFragmentDetailsBinding {
        return CharactersFragmentDetailsBinding.inflate(inflater, container, false)
    }

    override fun getViewLifecycle(binding: CharactersFragmentDetailsBinding): LifecycleObserver {
        return object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                binding.backImage.setOnClickListener { findNavController().navigateUp() }
            }
        }
    }
}
