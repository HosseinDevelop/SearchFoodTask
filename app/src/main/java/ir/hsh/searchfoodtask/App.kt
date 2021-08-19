package ir.hsh.searchfoodtask

import android.app.Application
import ir.hsh.searchfoodtask.di.component.AppComponent
import ir.hsh.searchfoodtask.di.component.DaggerAppComponent
import ir.hsh.searchfoodtask.di.module.ContextModule
import ir.hsh.searchfoodtask.di.module.NetworkModule
import ir.hsh.searchfoodtask.utils.BASE_URL

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDaggerComponent()

    }

    fun getNetworkComponent(): AppComponent {
        return appComponent
    }

    private fun initDaggerComponent(): AppComponent {
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .networkModule(NetworkModule(BASE_URL))
            .build()
        return appComponent

    }
}