package com.test.transferwise.feature.characters.di

import android.content.Context
import com.test.transferwise.common.ComponentInjector
import com.test.transferwise.core.characters.di.CharactersCoreInjector

object CharactersFeatureInjector : ComponentInjector<CharactersFeatureComponent, Context>() {
    override fun createComponent(dependency: Context): CharactersFeatureComponent {
        val appContext = dependency.applicationContext
        return DaggerCharactersFeatureComponent.factory()
            .create(CharactersCoreInjector.getComponent(appContext))
    }
}
