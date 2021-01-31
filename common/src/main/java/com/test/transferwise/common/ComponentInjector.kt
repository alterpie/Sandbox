package com.test.transferwise.common

/** ComponentInjector is used to achieve scalability for access to specific dagger component.
 * For example if we need to access a dagger component from different modules but want to use
 * the same instance of dagger component so we won't create duplicate instances of repositories
 * or interactors that need to be singletons is the scope of one dagger component. ComponentInjector
 * keeps a reference to one dagger component and can clear the reference if we need to drop all
 * instances from component(for example, when user leaves the feature and navigates to higher level).
 * Allows to pass some Dependency for component initialisation(usually Context or some id
 * from higher-level component).
 */
abstract class ComponentInjector<Component, Dependency> :
    IComponentInjector<Component, Dependency> {

    private var component: Component? = null

    protected abstract fun createComponent(dependency: Dependency): Component

    @Synchronized
    override fun getComponent(dependency: Dependency): Component {
        return component ?: createComponent(dependency).also { component = it }
    }

    @Synchronized
    override fun clearComponent() {
        component = null
    }
}
