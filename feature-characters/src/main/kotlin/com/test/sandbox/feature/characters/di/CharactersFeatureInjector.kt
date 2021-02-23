package com.test.sandbox.feature.characters.di

import android.content.Context
import com.test.sandbox.common.di.ComponentInjector
import com.test.sandbox.core.characters.di.CharactersCoreInjector

object CharactersFeatureInjector : ComponentInjector<CharactersFeatureComponent, Context>() {
    override fun createComponent(dependency: Context): CharactersFeatureComponent {
        val appContext = dependency.applicationContext
        return DaggerCharactersFeatureComponent.factory()
            .create(CharactersCoreInjector.getComponent(appContext))
    }
}
