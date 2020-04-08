package org.xtras.daggerviewmodelfactory

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import org.junit.Assert
import org.junit.Test
import javax.inject.Inject

class DaggerViewModelFactoryTests {
    @Test
    fun `When I try to get the View Model Factory and build TestViewModel, it should work`() {
        val factoryContainer = ViewModelFactoryContainer()
        DaggerTestComponent.create().inject(factoryContainer)
        Assert.assertTrue(factoryContainer.viewModelFactory is DaggerViewModelFactory)
    }

    @Test
    fun `When I try to get a TestViewModel using the Factory, it should work`() {
        val factoryContainer = ViewModelFactoryContainer()
        DaggerTestComponent.create().inject(factoryContainer)

        ViewModelProvider(
            ViewModelStore(),
            factoryContainer.viewModelFactory
        )[TestViewModel::class.java]
    }
}

class ViewModelFactoryContainer {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}