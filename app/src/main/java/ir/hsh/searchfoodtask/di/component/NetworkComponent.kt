package ir.hsh.searchfoodtask.di.component

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder
import dagger.Component
import ir.hsh.searchfoodtask.data.repository.NetworkRepository
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModelFactory
import ir.hsh.searchfoodtask.di.module.GlideModule
import ir.hsh.searchfoodtask.di.module.NetworkModule
import ir.hsh.searchfoodtask.ui.home.HomeFragment
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, GlideModule::class])
interface NetworkComponent {
    fun getRetrofit(): Retrofit
    fun getGlideRequestBuilder(): RequestBuilder<Drawable>
    fun inject(networkRepository: NetworkRepository)
    fun inject(networkViewModelFactory: NetworkViewModelFactory)
    fun inject(fragment: HomeFragment)
}