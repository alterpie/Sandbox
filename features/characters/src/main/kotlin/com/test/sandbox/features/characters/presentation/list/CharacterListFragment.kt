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
import com.test.mvi.Event
import com.test.sandbox.core.ui.BaseFragment
import com.test.sandbox.core.ui.ErrorEvent
import com.test.sandbox.feature.characters.databinding.CharactersFragmentListBinding
import com.test.sandbox.features.characters.di.CharactersFeatureInjector
import com.test.sandbox.features.characters.extensions.viewModels
import com.test.sandbox.features.characters.presentation.list.adapter.CharactersListAdapter
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListAction
import com.test.sandbox.features.characters.presentation.list.mvi.CharactersListState
import com.test.sandbox.libraries.characters.model.Character
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Provider

class CharacterListFragment : BaseFragment<CharactersFragmentListBinding>() {

    companion object {
        private const val EXTRA_LAYOUT_MANAGER_STATE = "EXTRA_LAYOUT_MANAGER_STATE"
    }

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
                val charactersAdapter = CharactersListAdapter { openDetails(it, binding) }

                with(binding.characterList) {
                    layoutManager = LinearLayoutManager(context)
                    findNavController()
                        .currentBackStackEntry
                        ?.savedStateHandle
                        ?.let { handle ->
                            layoutManager!!.onRestoreInstanceState(
                                handle.get(EXTRA_LAYOUT_MANAGER_STATE)
                            )
                            handle.set(EXTRA_LAYOUT_MANAGER_STATE, null)
                        }

                    adapter = charactersAdapter
                    setHasFixedSize(true)
                }

                owner.observe(viewModel.events) { onEvent(it, binding) }
                owner.observe(viewModel.state) { render(it, charactersAdapter, binding) }
            }
        }
    }

    private fun onEvent(event: Event, binding: CharactersFragmentListBinding) {
        when (event) {
            is ErrorEvent -> {
                Snackbar
                    .make(binding.root, event.throwable.message ?: "", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry") { viewModel.acceptAction(CharactersListAction.LoadCharacters) }
                    .show()
            }
            else -> onEvent(event)
        }
    }

    private fun openDetails(character: Character, binding: CharactersFragmentListBinding) {
        val navController = findNavController()
        navController
            .currentBackStackEntry
            ?.savedStateHandle
            ?.set(
                EXTRA_LAYOUT_MANAGER_STATE,
                binding.characterList.layoutManager!!.onSaveInstanceState()
            )
        viewModel.acceptAction(CharactersListAction.OpenDetails(character))
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

