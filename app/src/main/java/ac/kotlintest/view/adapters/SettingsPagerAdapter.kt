package ac.kotlintest.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*


class SettingsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var fragments = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addFrag(fragment: Fragment) = fragments.add(fragment)

}