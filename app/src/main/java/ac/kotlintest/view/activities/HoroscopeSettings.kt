package ac.kotlintest.view.activities

import ac.kotlintest.R
import ac.kotlintest.model.java.DailyHoroscopeJ
import ac.kotlintest.view.adapters.SettingsPagerAdapter
import ac.kotlintest.view.fragments.ChooseYourHoroscope
import ac.kotlintest.view.fragments.DailyHoroscopeFragment
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_horoscope_settings.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

internal class HoroscopeSettings : AppCompatActivity() {

    var chooseYourHoroscopeFragment : ChooseYourHoroscope? = null
    var dailyHoroscopeFragment : DailyHoroscopeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscope_settings)

        chooseYourHoroscopeFragment = ChooseYourHoroscope()
        dailyHoroscopeFragment = DailyHoroscopeFragment()

        settingsViewPager(
                addSettingsFragmentToAdapter(chooseYourHoroscopeFragment!!, dailyHoroscopeFragment!!)
        )
    }

    //add fragments to adapter
    fun addSettingsFragmentToAdapter(welcomeFr: ChooseYourHoroscope,
                                     dailyHoroscopeFragmentFr: DailyHoroscopeFragment) : SettingsPagerAdapter {
        val settingsAdapter = SettingsPagerAdapter(supportFragmentManager)
        settingsAdapter.addFrag(welcomeFr)
        settingsAdapter.addFrag(dailyHoroscopeFragmentFr)

        return settingsAdapter
    }

    //set settings to view pager
    fun settingsViewPager(settingsAdapter : SettingsPagerAdapter){
        viewpager.setPageTransformer(false, ViewPager.PageTransformer { view, fl ->  view.alpha = Math.abs(Math.abs(fl) - 1) })

        viewpager.setBackgroundResource(R.drawable.bg_s3)
        viewpager.setScaleType(1)
        viewpager.setOnTouchListener { view, motionEvent -> true }
        viewpager.setOverlapPercentage(0.8f)
        viewpager.adapter = settingsAdapter
    }

    //eventbus register
    override fun onStart(){
        super.onStart()
        EventBus.getDefault().register(this);
    }

    //eventbus unregister
    override fun onStop(){
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    fun nextPage() { viewpager.currentItem = viewpager.currentItem + 1 }
    fun previewPage() { viewpager.currentItem = viewpager.currentItem - 1 }

    fun clickItemHoroscope(v: View?){  chooseYourHoroscopeFragment!!.clickItemHoroscope(v) }

    fun setItemHoroscopePosition(pos : String) { dailyHoroscopeFragment!!.horoscopePosition = pos }

    fun getCurrentHoroscope() { dailyHoroscopeFragment!!.getCurrentHoroscope() }

    //back pressed for fragments
    override fun onBackPressed(){
        var count = viewpager.currentItem

        if(count == 0) super.onBackPressed()
        else previewPage()
    }

    //subscriber on data from api
    @Subscribe(threadMode = ThreadMode.ASYNC)
    fun getSeparatedHoroscope(dailyHoroscope : DailyHoroscopeJ) {
        dailyHoroscopeFragment!!.setDisplayHoroscopeData(dailyHoroscope)
    }
}


