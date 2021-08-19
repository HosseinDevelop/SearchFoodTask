package ir.hsh.searchfoodtask.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.hsh.searchfoodtask.data.model.MenuModelItem
import ir.hsh.searchfoodtask.data.repository.NetworkRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(val networkRepository: NetworkRepository) : ViewModel() {

    var postInfoLiveData: LiveData<List<MenuModelItem>> = MutableLiveData()

    init {
        fetchMenuList()
    }

    fun fetchMenuList() {
        postInfoLiveData = networkRepository.fetchMenuList()
    }

}