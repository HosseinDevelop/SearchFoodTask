package ir.hsh.searchfoodtask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.hsh.searchfoodtask.di.ViewModelKey
import ir.hsh.searchfoodtask.di.factory.ViewModelFactory
import ir.hsh.searchfoodtask.ui.home.HomeViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel


}