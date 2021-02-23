package com.test.sandbox.features.characters.di

import android.content.Context
import com.test.sandbox.common.di.ComponentInjector
import com.test.sandbox.libraries.characters.di.CharactersLibraryInjector

object CharactersFeatureInjector : ComponentInjector<CharactersFeatureComponent, Context>() {
    override fun createComponent(dependency: Context): CharactersFeatureComponent {
        val appContext = dependency.applicationContext
        return DaggerCharactersFeatureComponent.factory()
            .create(CharactersLibraryInjector.getComponent(appContext))
    }
}
