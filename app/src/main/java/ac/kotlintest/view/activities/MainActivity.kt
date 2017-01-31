package ac.kotlintest.view.activities

import ac.kotlintest.R
import ac.kotlintest.model.pojo.HoroscopeInfItem
import ac.kotlintest.view.fragments.ChooseYourHor
import ac.kotlintest.view.fragments.InfAboutYourHor
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*

internal class MainActivity : AppCompatActivity() {

    var chooseYourHoroscopeFragment : ChooseYourHor? = null
    var infAboutYourHor: InfAboutYourHor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        chooseYourHoroscopeFragment = ChooseYourHor()
        infAboutYourHor = InfAboutYourHor()

        settingsViewPager(
                addSettingsFragmentToAdapter(chooseYourHoroscopeFragment!!, infAboutYourHor!!)
        )
    }

    //add fragments to adapter
    fun addSettingsFragmentToAdapter(welcomeFr: ChooseYourHor,
                                     infAboutYourHorFr: InfAboutYourHor) : ac.kotlintest.view.adapters.ViewPagerAdapter {
        val settingsAdapter = ac.kotlintest.view.adapters.ViewPagerAdapter(supportFragmentManager)
        settingsAdapter.addFrag(welcomeFr)
        settingsAdapter.addFrag(infAboutYourHorFr)

        return settingsAdapter
    }

    //set settings to view pager
    fun settingsViewPager(settingsAdapter : ac.kotlintest.view.adapters.ViewPagerAdapter){
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

    fun setItemHoroscopePosition(pos : Int) { infAboutYourHor!!.horoscopePosition = pos }

    fun getDailyHoroscope() { infAboutYourHor!!.getDailyHoroscope() }

    //back pressed for fragments
    override fun onBackPressed(){
        var count = viewpager.currentItem

        if(count == 0) super.onBackPressed()
        else previewPage()
    }

    //subscriber on data from api
    @Subscribe(threadMode = ThreadMode.ASYNC)
    fun getSeparatedHoroscope(list: ArrayList<HoroscopeInfItem>) {
        infAboutYourHor!!.setDisplayHoroscopeData(list)
    }

    //subscriber on error from server
    @Subscribe(threadMode = ThreadMode.ASYNC)
    fun getErrorFromServer(textError: String){
        runOnUiThread {
            infAboutYourHor!!.hideProgressDialog()
            previewPage()
            Toast.makeText(baseContext, textError, Toast.LENGTH_SHORT).show()
        }
    }
}


