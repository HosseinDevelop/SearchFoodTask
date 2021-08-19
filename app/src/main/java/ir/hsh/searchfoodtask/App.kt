package ir.hsh.searchfoodtask

import android.app.Application
import android.content.Context
import ir.hsh.searchfoodtask.di.component.DaggerAppComponent
import ir.hsh.searchfoodtask.di.component.AppComponent
import ir.hsh.searchfoodtask.di.module.ContextModule
import ir.hsh.searchfoodtask.di.module.NetworkModule

class App:Application() {
    companion object {
        var ctx: Context? = null
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        appComponent = initDaggerComponent()

    }

    fun getNetworkComponent(): AppComponent {
        return appComponent
    }

    fun initDaggerComponent():AppComponent{
        appComponent = DaggerAppComponent
            .builder()

            .contextModule(ContextModule(ctx!!))
            .networkModule(NetworkModule("https://cdn.opeqe.com/"))
            .build()
        return  appComponent

    }
}