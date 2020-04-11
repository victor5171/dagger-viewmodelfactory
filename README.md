# ViewModelFactory
A library that provides an easy-to-use **ViewModelProvider.Factory** for projects that use **Dagger2**!

[![CircleCI](https://circleci.com/gh/victor5171/dagger-viewmodelfactory/tree/master.svg?style=shield)](https://circleci.com/gh/victor5171/dagger-viewmodelfactory/tree/master)

[ ![Download](https://api.bintray.com/packages/victor5171/xtras/dagger-viewmodelfactory/images/download.svg) ](https://bintray.com/victor5171/xtras/dagger-viewmodelfactory/_latestVersion)

## How to get it

1 - Add the repository:

    repositories { 
	    maven { 
		    url "https://dl.bintray.com/victor5171/xtras"
		}
    }

2 - Add the library

    implementation("org.xtras.daggerviewmodelfactory:dagger-viewmodelfactory:$version")

You can check the latest version [here](https://github.com/victor5171/dagger-viewmodelfactory/releases)

## How to use it

The library takes use of the **@IntoMap** functionality of Dagger2, where you put elements in a map where the key is mapped by the qualifier **@ViewModelKey**.

Lets suppose you have the ViewModel below:

    class TestViewModel @Inject constructor(private val testRepository: TestRepository) : ViewModel() {  
    }

You have to declare your ViewModels using this qualifier and sending the type of the ViewModel as a parameter of this qualifier, like on the example below:

    @Module  
    interface MyFeatureModule {  
	    @Binds  
	    @IntoMap
	    @ViewModelKey(TestViewModel::class)  
        fun bindTestViewModel(viewModel: TestViewModel): ViewModel  
    }

Remember to always declare your provider returning the ViewModel base type and not the specified ViewModel. You have to declare the real ViewModel as the binding type.

You also have to declare a provider that binds the **DaggerViewModelFactory** to **ViewModelProvider.Factory**, like on the example below:

    @Binds  
    fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

Another option is to just use **BaseViewModelFactoryModule** that this library provides, and inherit from it in any of your modules as this Module already provides this binding, like on the example below:

    @Module  
    interface ViewModelFactoryModule : BaseViewModelFactoryModule

After that, you are ready to go!  🍺

## Credits
[https://github.com/android/architecture-components-samples/tree/master/GithubBrowserSample](https://github.com/android/architecture-components-samples/tree/master/GithubBrowserSample)

[https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c](https://medium.com/@marco_cattaneo/android-viewmodel-and-factoryprovider-good-way-to-manage-it-with-dagger-2-d9e20a07084c)

