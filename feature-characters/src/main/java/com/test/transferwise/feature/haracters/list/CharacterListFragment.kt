package com.test.transferwise.feature.haracters.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.test.transferwise.core.ui.BaseFragment
import com.test.transferwise.feature.haracters.databinding.CharactersFragmentListBinding

class CharacterListFragment : BaseFragment<CharactersFragmentListBinding>() {

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): CharactersFragmentListBinding {
        return CharactersFragmentListBinding.inflate(inflater, container, false)
    }

    override fun getViewLifecycle(binding: CharactersFragmentListBinding): LifecycleObserver {
        return object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                binding.toDetailsButton.setOnClickListener {
                    findNavController().navigate(
                        CharacterListFragmentDirections.toCharacterDetails()
                    )
                }
            }
        }
    }

    override fun handleWindowInsets(
        binding: CharactersFragmentListBinding,
        insets: WindowInsetsCompat
    ): Boolean {
        binding.characterList.updatePadding(
            top = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top,
            bottom = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
        )
        return true
    }
}

