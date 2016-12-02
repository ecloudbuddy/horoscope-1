package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.model.java.DailyHoroscopeJ
import ac.kotlintest.view.presenters.DailyHoroscopePresenter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_horoscope_descriptions.view.*

class DailyHoroscopeFragment : Fragment() {

    var horoscopePosition : String = null.toString()
    var dailyHoroscope : DailyHoroscopePresenter = DailyHoroscopePresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_horoscope_descriptions, container, false)

        return view
    }

    //get horoscope data
    fun getCurrentHoroscope(){
        dailyHoroscope.getDailyHoroscope()
    }

    //??
    fun setDisplayHoroscopeData(dailyHoroscope : DailyHoroscopeJ){
        when (horoscopePosition){
            "1" -> setDataToDisplayHoroscope(R.drawable.aries, dailyHoroscope.aquariusToday, dailyHoroscope.aquariusTomorrow, dailyHoroscope.aquariusTomorrow02)
            "2" -> setDataToDisplayHoroscope(R.drawable.taurus, dailyHoroscope.taurusToday, dailyHoroscope.taurusTomorrow, dailyHoroscope.taurusTomorrow02)
            "3" -> setDataToDisplayHoroscope(R.drawable.gemini, dailyHoroscope.geminiToday, dailyHoroscope.geminiTomorrow, dailyHoroscope.geminiTomorrow02)
            "4" -> setDataToDisplayHoroscope(R.drawable.cancer, dailyHoroscope.cancerToday, dailyHoroscope.cancerTomorrow, dailyHoroscope.cancerTomorrow02)
            "5" -> setDataToDisplayHoroscope(R.drawable.leo, dailyHoroscope.leoToday, dailyHoroscope.leoTomorrow, dailyHoroscope.leoTomorrow02)
            "6" -> setDataToDisplayHoroscope(R.drawable.virgo, dailyHoroscope.virgoToday, dailyHoroscope.virgoTomorrow, dailyHoroscope.virgoTomorrow02)
            "7" -> setDataToDisplayHoroscope(R.drawable.libra, dailyHoroscope.libraToday, dailyHoroscope.libraTomorrow, dailyHoroscope.libraTomorrow02)
            "8" -> setDataToDisplayHoroscope(R.drawable.scorpio, dailyHoroscope.scorpioToday, dailyHoroscope.scorpioTomorrow, dailyHoroscope.scorpioTomorrow02)
            "9" -> setDataToDisplayHoroscope(R.drawable.sagittarius, dailyHoroscope.sagittariusToday, dailyHoroscope.sagittariusTomorrow, dailyHoroscope.sagittariusTomorrow02)
            "10" -> setDataToDisplayHoroscope(R.drawable.capricorn, dailyHoroscope.capricornToday, dailyHoroscope.capricornTomorrow, dailyHoroscope.cancerTomorrow02)
            "11" -> setDataToDisplayHoroscope(R.drawable.aquarius, dailyHoroscope.aquariusToday, dailyHoroscope.aquariusTomorrow, dailyHoroscope.aquariusTomorrow02)
            "12" -> setDataToDisplayHoroscope(R.drawable.pisces, dailyHoroscope.piscesToday, dailyHoroscope.piscesTomorrow, dailyHoroscope.piscesTomorrow02)
        }
    }

    fun setDataToDisplayHoroscope(idRes : Int, today : String, tomorrow : String, afterTomorrow : String) {
        activity.runOnUiThread({
            view!!.logo_horoscope.setImageResource(idRes)
            view!!.descriptionToday.text = today
            view!!.descriptionTomorrow.text = tomorrow
            view!!.descriptionDayAfterTomorrow.text = afterTomorrow
        })
    }

}
