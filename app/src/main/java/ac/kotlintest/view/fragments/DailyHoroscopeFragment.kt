package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.model.java.DailyHoroscopeJ
import ac.kotlintest.view.presenters.DailyHoroscopePresenter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.fragment_horoscope_descriptions.view.*

class DailyHoroscopeFragment : Fragment() {

    var horoscopePosition : String = null.toString()
    var dailyHoroscope : DailyHoroscopePresenter = DailyHoroscopePresenter()
    var hud : KProgressHUD? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_horoscope_descriptions, container, false)

        return view
    }

    //get horoscope data
    fun getCurrentHoroscope(){
        showProgressDialog()
        dailyHoroscope.getDailyHoroscope()
    }

    //???
    fun setDisplayHoroscopeData(dailyHoroscope : DailyHoroscopeJ){
        when (horoscopePosition){
            "1" -> setDataToDisplayHoroscope(R.drawable.aries, getString(R.string.aries), dailyHoroscope.aquariusToday, dailyHoroscope.aquariusTomorrow, dailyHoroscope.aquariusTomorrow02)
            "2" -> setDataToDisplayHoroscope(R.drawable.taurus, getString(R.string.taurus), dailyHoroscope.taurusToday, dailyHoroscope.taurusTomorrow, dailyHoroscope.taurusTomorrow02)
            "3" -> setDataToDisplayHoroscope(R.drawable.gemini, getString(R.string.gemini), dailyHoroscope.geminiToday, dailyHoroscope.geminiTomorrow, dailyHoroscope.geminiTomorrow02)
            "4" -> setDataToDisplayHoroscope(R.drawable.cancer, getString(R.string.cancer), dailyHoroscope.cancerToday, dailyHoroscope.cancerTomorrow, dailyHoroscope.cancerTomorrow02)
            "5" -> setDataToDisplayHoroscope(R.drawable.leo, getString(R.string.leo), dailyHoroscope.leoToday, dailyHoroscope.leoTomorrow, dailyHoroscope.leoTomorrow02)
            "6" -> setDataToDisplayHoroscope(R.drawable.virgo, getString(R.string.virgo), dailyHoroscope.virgoToday, dailyHoroscope.virgoTomorrow, dailyHoroscope.virgoTomorrow02)
            "7" -> setDataToDisplayHoroscope(R.drawable.libra, getString(R.string.libra), dailyHoroscope.libraToday, dailyHoroscope.libraTomorrow, dailyHoroscope.libraTomorrow02)
            "8" -> setDataToDisplayHoroscope(R.drawable.scorpio, getString(R.string.scorpio), dailyHoroscope.scorpioToday, dailyHoroscope.scorpioTomorrow, dailyHoroscope.scorpioTomorrow02)
            "9" -> setDataToDisplayHoroscope(R.drawable.sagittarius, getString(R.string.sagittarius), dailyHoroscope.sagittariusToday, dailyHoroscope.sagittariusTomorrow, dailyHoroscope.sagittariusTomorrow02)
            "10" -> setDataToDisplayHoroscope(R.drawable.capricorn, getString(R.string.capricorn), dailyHoroscope.capricornToday, dailyHoroscope.capricornTomorrow, dailyHoroscope.cancerTomorrow02)
            "11" -> setDataToDisplayHoroscope(R.drawable.aquarius, getString(R.string.aquarius), dailyHoroscope.aquariusToday, dailyHoroscope.aquariusTomorrow, dailyHoroscope.aquariusTomorrow02)
            "12" -> setDataToDisplayHoroscope(R.drawable.pisces, getString(R.string.pisces), dailyHoroscope.piscesToday, dailyHoroscope.piscesTomorrow, dailyHoroscope.piscesTomorrow02)
        }
    }

    fun setDataToDisplayHoroscope(idRes : Int, nameHoroscope : String, today : String, tomorrow : String, afterTomorrow : String) {
        activity.runOnUiThread({
            view!!.logo_horoscope.setImageResource(idRes)
            view!!.nameHoroscope.text = nameHoroscope
            view!!.descriptionToday.text = today
            view!!.descriptionTomorrow.text = tomorrow
            view!!.descriptionDayAfterTomorrow.text = afterTomorrow
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
