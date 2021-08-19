package ir.hsh.searchfoodtask.di.component

import dagger.Component
import ir.hsh.searchfoodtask.di.module.ViewPagerModule
import ir.hsh.searchfoodtask.ui.main.MainActivity
import ir.hsh.searchfoodtask.ui.main.MainPagerAdapter
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewPagerModule::class])
interface ActivityComponent {
    fun getViewPagerAdapter(): MainPagerAdapter
    fun inject(mainActivity: MainActivity)
}