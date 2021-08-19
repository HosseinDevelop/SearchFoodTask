package ir.hsh.searchfoodtask.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import ir.hsh.searchfoodtask.R
import ir.hsh.searchfoodtask.databinding.ActivityMainBinding
import ir.hsh.searchfoodtask.di.component.DaggerActivityComponent
import ir.hsh.searchfoodtask.di.module.ViewPagerModule
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var adapterViewPager: MainPagerAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerActivityComponent.builder()
            .viewPagerModule(ViewPagerModule(this))
            .build()
            .inject(this)

        setUpViewPager()
        setupBottomNavigation()

    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    binding.viewPager.currentItem = 0
                    true
                }
                R.id.perks -> {
                    binding.viewPager.currentItem = 1
                    true
                }
                R.id.orders -> {
                    binding.viewPager.currentItem = 2
                    true
                }
                R.id.account -> {
                    binding.viewPager.currentItem = 3
                    true
                }
                else -> false
            }
        })
    }

    private fun setUpViewPager() {
        binding.viewPager.adapter = adapterViewPager
        binding.viewPager.currentItem = 0
        binding.viewPager.offscreenPageLimit = 4
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                //bottomNavigation.currentItem = position

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }
}

