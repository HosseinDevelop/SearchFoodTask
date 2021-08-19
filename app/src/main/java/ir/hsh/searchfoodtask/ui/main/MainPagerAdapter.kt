package ir.hsh.searchfoodtask.ui.main

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ir.hsh.searchfoodtask.ui.account.AccountFragment
import ir.hsh.searchfoodtask.ui.home.HomeFragment
import ir.hsh.searchfoodtask.ui.order.OrderFragment
import ir.hsh.searchfoodtask.ui.perk.PerkFragment
import javax.inject.Inject

class MainPagerAdapter @Inject constructor(fragmentManager: FragmentManager?) : FragmentPagerAdapter(fragmentManager!!) {
    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> PerkFragment()
            2 -> OrderFragment()
            3 -> AccountFragment()
            else -> HomeFragment()
        }
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence? {
        return "Page $position"
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

    companion object {
        private const val NUM_ITEMS = 4
    }
}