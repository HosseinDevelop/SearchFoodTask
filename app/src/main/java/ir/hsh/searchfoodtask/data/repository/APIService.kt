package ir.hsh.searchfoodtask.data.repository

import ir.hsh.searchfoodtask.data.model.MenuModelItem
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("task/menu.json")
    fun getMenus(): Call<List<MenuModelItem>>
}