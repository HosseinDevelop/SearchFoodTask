package ir.hsh.searchfoodtask.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import ir.hsh.searchfoodtask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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


}

