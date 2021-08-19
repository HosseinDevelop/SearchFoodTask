package ir.hsh.searchfoodtask.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.hsh.searchfoodtask.data.model.MenuModelItem
import ir.hsh.searchfoodtask.data.repository.NetworkRepository

class NetworkViewModel(val networkRepository: NetworkRepository) : ViewModel() {
    var postInfoLiveData: LiveData<List<MenuModelItem>> = MutableLiveData()

    init {
        fetchMenuList()
    }

    private fun fetchMenuList() {
        postInfoLiveData = networkRepository.fetchMenuList()
    }
}