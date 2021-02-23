package com.test.sandbox.libraries.characters.di

import android.content.Context
import com.test.sandbox.common.di.ComponentInjector
import com.test.sandbox.network.di.NetworkInjector

object CharactersLibraryInjector : ComponentInjector<CharactersLibraryComponent, Context>() {

    override fun createComponent(dependency: Context): CharactersLibraryComponent {
        val appContext = dependency.applicationContext
        return DaggerCharactersLibraryComponent.factory()
            .create(
                appContext,
                NetworkInjector.getComponent(Unit).charactersApi
            )
    }
}
