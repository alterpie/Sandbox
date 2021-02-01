package com.test.transferwise.core.characters.di

import android.content.Context
import com.test.transferwise.common.ComponentInjector
import com.test.transferwise.network.di.NetworkInjector

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
