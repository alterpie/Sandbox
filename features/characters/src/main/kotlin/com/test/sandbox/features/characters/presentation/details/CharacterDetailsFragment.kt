package com.test.sandbox.features.characters.presentation.details

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
import com.test.sandbox.core.ui.BaseFragment
import com.test.sandbox.feature.characters.databinding.CharactersFragmentDetailsBinding
import com.test.sandbox.features.characters.di.CharactersFeatureInjector
import com.test.sandbox.features.characters.extensions.viewModels
import com.test.sandbox.features.characters.presentation.details.mvi.CharacterDetailsAction
import com.test.sandbox.features.characters.presentation.details.mvi.CharacterDetailsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Provider

class CharacterDetailsFragment : BaseFragment<CharactersFragmentDetailsBinding>() {

    @Inject
    internal lateinit var vmProvider: Provider<CharacterDetailsViewModel>
    private val viewModel: CharacterDetailsViewModel by viewModels { vmProvider.get() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CharactersFeatureInjector.getComponent(context)
            .characterDetailsSubcomponent
            .create(navArgs<CharacterDetailsFragmentArgs>().value.characterId)
            .inject(this)
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
                owner.observe(viewModel.events, ::onEvent)
                owner.observe(viewModel.state) { render(it, binding) }

                binding.backImage.setOnClickListener {
                    viewModel.acceptAction(CharacterDetailsAction.NavigateBack)
                }
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
