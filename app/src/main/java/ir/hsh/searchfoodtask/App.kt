package ir.hsh.searchfoodtask

import android.app.Application
import android.content.Context
import ir.hsh.searchfoodtask.di.component.DaggerNetworkComponent
import ir.hsh.searchfoodtask.di.component.NetworkComponent
import ir.hsh.searchfoodtask.di.module.ContextModule
import ir.hsh.searchfoodtask.di.module.NetworkModule

class App:Application() {
    companion object {
        var ctx: Context? = null
        lateinit var networkComponent: NetworkComponent
    }
    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        networkComponent = initDaggerComponent()

    }

    fun getNetworkComponent(): NetworkComponent {
        return networkComponent
    }

    fun initDaggerComponent():NetworkComponent{
        networkComponent = DaggerNetworkComponent
            .builder()
            .contextModule(ContextModule(ctx!!))
            .networkModule(NetworkModule("https://cdn.opeqe.com/"))
            .build()
        return  networkComponent

    }
}