package com.test.sandbox.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.test.mvi.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun getViewLifecycle(binding: VB): LifecycleObserver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = createViewBinding(inflater, container)
        viewLifecycleOwner.lifecycle.addObserver(getViewLifecycle(binding))
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            if (!handleWindowInsets(binding, insets)) {
                binding.root.updatePadding(
                    top = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top,
                    bottom = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
                )
            }
            insets
        }
        return binding.root
    }

    protected inline fun <T> LifecycleOwner.observe(
        flow: Flow<T>,
        crossinline action: (T) -> Unit
    ) {
        flow
            .onEach { action(it) }
            .launchIn(lifecycleScope)
    }

    protected fun onEvent(event: Event) {
        when (event) {
            is NavigationEvent -> navigate(event)
            is ErrorEvent -> handleError(event)
        }
    }

    private fun navigate(event: NavigationEvent) {
        val navController = findNavController()
        when (event) {
            is Navigate -> navController.navigate(event.direction)
            NavigateUp -> navController.navigateUp()
        }
    }

    private fun handleError(event: ErrorEvent) {
        val length = when (event) {
            is ErrorEvent.Indefinite -> Snackbar.LENGTH_INDEFINITE
            is ErrorEvent.Long -> Snackbar.LENGTH_LONG
            is ErrorEvent.Short -> Snackbar.LENGTH_SHORT
        }
        Snackbar
            .make(requireView(), event.throwable.message ?: "", length)
            .show()
    }

    open fun handleWindowInsets(binding: VB, insets: WindowInsetsCompat): Boolean = false
}
