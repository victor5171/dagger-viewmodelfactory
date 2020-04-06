package org.xtras.daggerviewmodelfactory.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import org.xtras.daggerviewmodelfactory.di.DaggerAppComponent
import org.xtras.daggerviewmodelfactory.viewmodel.TestViewModel

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var testViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testViewModel =
            ViewModelProvider(viewModelStore, viewModelFactory)[TestViewModel::class.java]
    }
}
