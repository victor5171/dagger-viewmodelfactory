package org.xtras.daggerviewmodelfactory.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.xtras.daggerviewmodelfactory.ViewModelKey
import org.xtras.daggerviewmodelfactory.viewmodel.TestViewModel

@Module
interface MyFeatureModule {
    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    fun bindTestViewModel(viewModel: TestViewModel): ViewModel
}
