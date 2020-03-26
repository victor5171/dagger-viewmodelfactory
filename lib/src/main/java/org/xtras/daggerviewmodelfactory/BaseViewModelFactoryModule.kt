package org.xtras.daggerviewmodelfactory

import androidx.lifecycle.ViewModelProvider
import dagger.Binds

/**
 * Inherit from this pseudo-module in your dagger module
 */
interface BaseViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}
