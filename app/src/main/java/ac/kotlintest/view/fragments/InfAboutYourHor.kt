package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.model.pojo.Horoscope
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
    var infAboutYourHorPresenter: InfAboutYourHorPresenter = InfAboutYourHorPresenter()
    var hud : KProgressHUD? = null
    var listButtons : List<RelativeLayout>? = null
    var staticUrl : Static = Static()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_horoscope_descriptions, container, false)

        listButtons = ArrayList(Arrays.asList(view.daily, view.ero, view.anti, view.bus, view.health, view.cook, view.love))

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
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_DAILY_HOROSCOPE)
        setCurrentItemBg(view!!.daily)
    }

    fun getEroHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_ERO_HOROSCOPE)
        setCurrentItemBg(view!!.ero)
    }

    fun getAntiHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_ANTI_HOROSCOPE)
        setCurrentItemBg(view!!.anti)
    }

    fun getBusHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_BUSINESS_HOROSCOPE)
        setCurrentItemBg(view!!.bus)
    }

    fun getHealHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_HEAL_HOROSCOPE)
        setCurrentItemBg(view!!.health)
    }

    fun getCookHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_COOK_HOROSCOPE)
        setCurrentItemBg(view!!.cook)
    }

    fun getLoveHoroscope(){
        showProgressDialog()
        infAboutYourHorPresenter.getHoroscope(staticUrl.URL_LOVE_HOROSCOPE)
        setCurrentItemBg(view!!.love)
    }

    //???
    fun setDisplayHoroscopeData(horoscope: Horoscope){
        when (horoscopePosition){
            0 -> setDataToDisplayHoroscope(R.drawable.aries, getString(R.string.aries), horoscope.ariesYesterday, horoscope.ariesToday, horoscope.arieTomorrow, horoscope.ariesTomorrow02)
            1 -> setDataToDisplayHoroscope(R.drawable.taurus, getString(R.string.taurus), horoscope.taurusYesterday, horoscope.taurusToday, horoscope.taurusTomorrow, horoscope.taurusTomorrow02)
            2 -> setDataToDisplayHoroscope(R.drawable.gemini, getString(R.string.gemini), horoscope.geminiYesterday, horoscope.geminiToday, horoscope.geminiTomorrow, horoscope.geminiTomorrow02)
            3 -> setDataToDisplayHoroscope(R.drawable.cancer, getString(R.string.cancer), horoscope.cancerYesterday, horoscope.cancerToday, horoscope.cancerTomorrow, horoscope.cancerTomorrow02)
            4 -> setDataToDisplayHoroscope(R.drawable.leo, getString(R.string.leo), horoscope.leoYesterday, horoscope.leoToday, horoscope.leoTomorrow, horoscope.leoTomorrow02)
            5 -> setDataToDisplayHoroscope(R.drawable.virgo, getString(R.string.virgo), horoscope.virgoYesterday, horoscope.virgoToday, horoscope.virgoTomorrow, horoscope.virgoTomorrow02)
            6 -> setDataToDisplayHoroscope(R.drawable.libra, getString(R.string.libra), horoscope.libraYesterday, horoscope.libraToday, horoscope.libraTomorrow, horoscope.libraTomorrow02)
            7 -> setDataToDisplayHoroscope(R.drawable.scorpio, getString(R.string.scorpio), horoscope.scorpioYesterday, horoscope.scorpioToday, horoscope.scorpioTomorrow, horoscope.scorpioTomorrow02)
            8 -> setDataToDisplayHoroscope(R.drawable.sagittarius, getString(R.string.sagittarius), horoscope.sagittariusYesterday, horoscope.sagittariusToday, horoscope.sagittariusTomorrow, horoscope.sagittariusTomorrow02)
            9 -> setDataToDisplayHoroscope(R.drawable.capricorn, getString(R.string.capricorn), horoscope.capricornYesterday, horoscope.capricornToday, horoscope.capricornTomorrow, horoscope.cancerTomorrow02)
            10 -> setDataToDisplayHoroscope(R.drawable.capricorn, getString(R.string.aquarius), horoscope.aquariusYesterday, horoscope.aquariusToday, horoscope.aquariusTomorrow, horoscope.aquariusTomorrow02)
            11 -> setDataToDisplayHoroscope(R.drawable.pisces, getString(R.string.pisces), horoscope.piscesYesterday, horoscope.piscesToday, horoscope.piscesTomorrow, horoscope.piscesTomorrow02)
        }
    }

    fun setDataToDisplayHoroscope(idRes : Int, nameHoroscope : String, yesterday : String, today : String, tomorrow : String, afterTomorrow : String) {
        activity.runOnUiThread({
            view!!.logo_horoscope.setImageResource(idRes)
            view!!.nameHoroscope.text = nameHoroscope
            view!!.descriptionToday.text = today
            view!!.descriptionTomorrow.text = tomorrow
            view!!.descriptionDayAfterTomorrow.text = afterTomorrow
            view!!.descriptionYesterday.text = yesterday
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
