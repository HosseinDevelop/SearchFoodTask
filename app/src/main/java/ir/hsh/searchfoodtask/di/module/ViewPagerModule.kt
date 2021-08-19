package ir.hsh.searchfoodtask.di.module

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import ir.hsh.searchfoodtask.ui.main.MainPagerAdapter
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class ViewPagerModule(val activity: AppCompatActivity) {

    @Singleton
    @Provides
    fun provideMainPagerAdapter(): MainPagerAdapter {
        return MainPagerAdapter(activity.supportFragmentManager)
    }
}