package ir.hsh.searchfoodtask.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.hsh.searchfoodtask.App
import ir.hsh.searchfoodtask.data.repository.NetworkRepository
import ir.hsh.searchfoodtask.di.component.AppComponent
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkViewModelFactory @Inject constructor(private val retrofit: Retrofit) : ViewModelProvider.Factory {

    @Inject
    lateinit var networkRepository: NetworkRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        var appComponent: AppComponent = App.appComponent
        appComponent.inject(this)
        if (modelClass.isAssignableFrom(NetworkViewModel::class.java)) {
            return NetworkViewModel(NetworkRepository(retrofit)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}