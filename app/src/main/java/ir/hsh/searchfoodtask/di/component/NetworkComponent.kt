package ir.hsh.searchfoodtask.di.component

import dagger.Component
import ir.hsh.searchfoodtask.data.repository.NetworkRepository
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModelFactory
import ir.hsh.searchfoodtask.di.module.NetworkModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun getRetrofit(): Retrofit

    fun inject(networkRepository: NetworkRepository)
    fun inject(networkViewModelFactory: NetworkViewModelFactory)
}