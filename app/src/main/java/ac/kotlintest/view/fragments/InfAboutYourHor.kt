package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.model.pojo.HoroscopeInfItem
import ac.kotlintest.until.Static
import ac.kotlintest.view.presenters.InfAboutYourHorPresenter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.fragment_horoscope_descriptions.view.*
import java.util.*

class InfAboutYourHor : Fragment() {

    var horoscopePosition : Int = 0
    var infAboutYourHorPresenter: InfAboutYourHorPresenter? = null
    var hud : KProgressHUD? = null
    var listButtons : List<RelativeLayout>? = null
    var staticUrl : Static = Static()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_horoscope_descriptions, container, false)

        listButtons = ArrayList(Arrays.asList(view.daily, view.ero, view.anti, view.bus, view.health, view.cook, view.love))
        infAboutYourHorPresenter = InfAboutYourHorPresenter(activity)

        view.daily.setOnClickListener { getDailyHoroscope() }
        view.ero.setOnClickListener { getEroHoroscope() }
        view.anti.setOnClickListener { getAntiHoroscope() }
        view.bus.setOnClickListener { getBusHoroscope() }
        view.health.setOnClickListener { getHealHoroscope() }
        view.cook.setOnClickListener { getCookHoroscope() }
        view.love.setOnClickListener { getLoveHoroscope() }

        return view
    }

    fun setCurrentItemBg(layout : RelativeLayout){
        for (currentLayout in listButtons!!){
            if(currentLayout == layout)
                currentLayout.setBackgroundResource(R.drawable.border_choose)
            else
                currentLayout.setBackgroundResource(R.drawable.border)
        }
    }

    fun getDailyHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_DAILY_HOROSCOPE)
        setCurrentItemBg(view!!.daily)
    }

    fun getEroHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_ERO_HOROSCOPE)
        setCurrentItemBg(view!!.ero)
    }

    fun getAntiHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_ANTI_HOROSCOPE)
        setCurrentItemBg(view!!.anti)
    }

    fun getBusHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_BUSINESS_HOROSCOPE)
        setCurrentItemBg(view!!.bus)
    }

    fun getHealHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_HEAL_HOROSCOPE)
        setCurrentItemBg(view!!.health)
    }

    fun getCookHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_COOK_HOROSCOPE)
        setCurrentItemBg(view!!.cook)
    }

    fun getLoveHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter!!.getHoroscope(staticUrl.URL_LOVE_HOROSCOPE)
        setCurrentItemBg(view!!.love)
    }

    //display current horoscope
    fun setDisplayHoroscopeData(list: ArrayList<HoroscopeInfItem>){

        var horoscopeInfItem: HoroscopeInfItem = list[horoscopePosition]

        activity.runOnUiThread({
            view!!.logo_horoscope.setImageResource(horoscopeInfItem.resImage)
            view!!.nameHoroscope.text = horoscopeInfItem.nameItem
            view!!.descriptionToday.text = horoscopeInfItem.descToday
            view!!.descriptionTomorrow.text = horoscopeInfItem.descTomorrow
            view!!.descriptionDayAfterTomorrow.text = horoscopeInfItem.descTomorrow02
            view!!.descriptionYesterday.text = horoscopeInfItem.descYesterday
        })

        hideProgressDialog()
    }

    //show progress dialog
    fun showProgressDialog(){
        if (hud == null)
            hud = KProgressHUD.create(activity)

        hud!!.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
        hud!!.setCancellable(false)
        hud!!.setAnimationSpeed(2)
        if (!activity.isFinishing) {
            hud!!.show()
        }
    }

    //hide progress dialog
    fun hideProgressDialog(){
        hud!!.dismiss()
    }

}

