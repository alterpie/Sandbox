package com.test.transferwise.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.viewbinding.ViewBinding

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

    open fun handleWindowInsets(binding: VB, insets: WindowInsetsCompat): Boolean = false
}
