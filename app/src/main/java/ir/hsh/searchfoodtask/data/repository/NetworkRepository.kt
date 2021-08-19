package ir.hsh.searchfoodtask.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.hsh.searchfoodtask.App
import ir.hsh.searchfoodtask.data.model.MenuModelItem
import ir.hsh.searchfoodtask.di.component.AppComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val retrofit: Retrofit) {

    lateinit var appComponent: AppComponent

    var menuList: MutableLiveData<List<MenuModelItem>> = MutableLiveData()

    init {
        var appComponent: AppComponent = App.appComponent
        appComponent.inject(this)
    }

    fun fetchMenuList(): LiveData<List<MenuModelItem>> {

        var apiService: APIService = retrofit.create(APIService::class.java)
        var postListInfo: Call<List<MenuModelItem>> = apiService.getMenus()
        postListInfo.enqueue(object : Callback<List<MenuModelItem>> {
            override fun onFailure(call: Call<List<MenuModelItem>>, t: Throwable) {
                Log.d("RetroRepository", "Failed:::" + t.message)
            }

            override fun onResponse(call: Call<List<MenuModelItem>>, response: Response<List<MenuModelItem>>) {
                var postInfoList = response.body()
                menuList.value = postInfoList

            }
        })

        return menuList

    }

}