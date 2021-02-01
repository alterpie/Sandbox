package com.test.transferwise.feature.characters.presentation.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.test.transferwise.core.ui.BaseFragment
import com.test.transferwise.feature.characters.databinding.CharactersFragmentDetailsBinding
import com.test.transferwise.feature.characters.di.CharactersFeatureInjector
import com.test.transferwise.feature.characters.extensions.viewModels
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CharacterDetailsFragment : BaseFragment<CharactersFragmentDetailsBinding>() {

    @Inject
    internal lateinit var vmFactory: CharacterDetailsViewModel.Factory
    private val viewModel: CharacterDetailsViewModel by viewModels {
        vmFactory.create(navArgs<CharacterDetailsFragmentArgs>().value.characterId)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CharactersFeatureInjector.getComponent(context).inject(this)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): CharactersFragmentDetailsBinding {
        return CharactersFragmentDetailsBinding.inflate(inflater, container, false)
    }

    override fun getViewLifecycle(binding: CharactersFragmentDetailsBinding): LifecycleObserver {
        return object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                viewModel.state
                    .onEach { render(it, binding) }
                    .launchIn(owner.lifecycleScope)
                binding.backImage.setOnClickListener { findNavController().navigateUp() }
            }
        }
    }

    private fun render(state: CharacterDetailsState, binding: CharactersFragmentDetailsBinding) {
        val character = state.character ?: return
        with(binding) {

            image.load(character.image)
            name.text = character.name
            gender.text = character.gender
            species.text = character.species
            status.text = character.status
        }
    }
}
