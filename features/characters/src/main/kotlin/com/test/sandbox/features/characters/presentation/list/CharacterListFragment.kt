package com.test.sandbox.features.characters.presentation.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.test.sandbox.core.ui.BaseFragment
import com.test.sandbox.feature.characters.databinding.CharactersFragmentListBinding
import com.test.sandbox.features.characters.di.CharactersFeatureInjector
import com.test.sandbox.features.characters.extensions.viewModels
import com.test.sandbox.features.characters.presentation.list.adapter.CharactersListAdapter
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListAction
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListEvent
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Provider

class CharacterListFragment : BaseFragment<CharactersFragmentListBinding>() {

    @Inject
    internal lateinit var vmProvider: Provider<CharactersListViewModel>
    private val viewModel: CharactersListViewModel by viewModels { vmProvider.get() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CharactersFeatureInjector.getComponent(context).inject(this)
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): CharactersFragmentListBinding {
        return CharactersFragmentListBinding.inflate(inflater, container, false)
    }

    override fun getViewLifecycle(binding: CharactersFragmentListBinding): LifecycleObserver {
        return object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                val charactersAdapter = CharactersListAdapter {
                    findNavController().navigate(
                        CharacterListFragmentDirections.toCharacterDetails(it.id)
                    )
                }
                with(binding.characterList) {
                    layoutManager = LinearLayoutManager(context)
                    adapter = charactersAdapter
                    setHasFixedSize(true)
                }
                viewModel.state
                    .onEach { render(it, charactersAdapter, binding) }
                    .launchIn(owner.lifecycleScope)

                viewModel.events
                    .onEach { handleEvent(it, binding) }
                    .launchIn(owner.lifecycleScope)
            }
        }
    }

    private fun handleEvent(event: Any, binding: CharactersFragmentListBinding) {
        when (event) {
            is CharactersListEvent.Error -> {
                Snackbar
                    .make(binding.root, event.throwable.message ?: "", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry") { viewModel.acceptAction(CharactersListAction.LoadCharacters) }
                    .show()
            }
        }
    }

    private fun render(
        state: CharactersListState,
        adapter: CharactersListAdapter,
        binding: CharactersFragmentListBinding
    ) {
        adapter.submitList(state.characters)
        binding.progress.isVisible = state.isLoading
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

