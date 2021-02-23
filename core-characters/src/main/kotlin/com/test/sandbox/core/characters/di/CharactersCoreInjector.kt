package com.test.sandbox.core.characters.di

import android.content.Context
import com.test.sandbox.common.di.ComponentInjector
import com.test.sandbox.network.di.NetworkInjector

object CharactersCoreInjector : ComponentInjector<CharactersCoreComponent, Context>() {

    override fun createComponent(dependency: Context): CharactersCoreComponent {
        val appContext = dependency.applicationContext
        return DaggerCharactersCoreComponent.factory()
            .create(
                appContext,
                NetworkInjector.getComponent(Unit).charactersApi
            )
    }
}
