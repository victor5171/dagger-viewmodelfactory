package org.xtras.daggerviewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [TestModule::class])
interface TestComponent {

    @Component.Factory
    interface Factory {
        fun create(): TestComponent
    }

    fun inject(factoryContainer: ViewModelFactoryContainer)
}

@Module
interface TestModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    fun bindTestViewModel(testViewModel: TestViewModel): ViewModel
}
