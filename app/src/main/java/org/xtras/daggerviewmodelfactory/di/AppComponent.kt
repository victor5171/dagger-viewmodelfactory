package org.xtras.daggerviewmodelfactory.di

import dagger.Component
import org.xtras.daggerviewmodelfactory.app.MainActivity

@Component(modules = [
    ViewModelFactoryModule::class,
    MyFeatureModule::class
])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}
