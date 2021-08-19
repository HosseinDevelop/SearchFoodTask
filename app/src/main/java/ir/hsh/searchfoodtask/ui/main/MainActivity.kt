package ir.hsh.searchfoodtask.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ir.hsh.searchfoodtask.utils.logi
import ir.hsh.searchfoodtask.App
import ir.hsh.searchfoodtask.R
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModel
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModelFactory

class MainActivity : AppCompatActivity() {


    lateinit var networkViewModel: NetworkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        fetchRetroInfo()

    }

    fun initViewModel() {
        var networkViewModelFactory = NetworkViewModelFactory(App.networkComponent.getRetrofit())
        networkViewModel = ViewModelProvider(this, networkViewModelFactory).get(NetworkViewModel::class.java)
    }

    fun fetchRetroInfo() {
        networkViewModel.postInfoLiveData?.observe(this, {
            it.forEach {
                logi(it.title.toString())
            }

        })
    }
}

