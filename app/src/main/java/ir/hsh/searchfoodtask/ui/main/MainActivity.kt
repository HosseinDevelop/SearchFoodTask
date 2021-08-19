package ir.hsh.searchfoodtask.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import ir.hsh.searchfoodtask.App
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModel
import ir.hsh.searchfoodtask.data.viewmodel.NetworkViewModelFactory
import ir.hsh.searchfoodtask.databinding.ActivityMainBinding
import ir.hsh.searchfoodtask.utils.logi
import ir.hsh.searchfoodtask.utils.logw


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var networkViewModel: NetworkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        fetchRetroInfo()
        val navController = Navigation.findNavController(this, ir.hsh.searchfoodtask.R.id.nav_host_app_fragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                ir.hsh.searchfoodtask.R.id.home -> {
                    navController.navigate(ir.hsh.searchfoodtask.R.id.homeFragment)
                    true
                }
                ir.hsh.searchfoodtask.R.id.perks -> {
                    navController.navigate(ir.hsh.searchfoodtask.R.id.perkFragment)
                    true
                }
                ir.hsh.searchfoodtask.R.id.orders -> {
                    navController.navigate(ir.hsh.searchfoodtask.R.id.orderFragment)
                    true
                }
                ir.hsh.searchfoodtask.R.id.account -> {
                    navController.navigate(ir.hsh.searchfoodtask.R.id.accountFragment)
                    true
                }
                else -> false
            }
        })

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

