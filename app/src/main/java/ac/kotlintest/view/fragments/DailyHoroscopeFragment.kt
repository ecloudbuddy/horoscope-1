package ac.kotlintest.view.fragments

import ac.kotlintest.R
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DailyHoroscopeFragment : Fragment() {

    var horoscopePosition : String = null.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings_horoscope, container, false)

        //var dailyHoroscope : DailyHoroscopePresenter = DailyHoroscopePresenter()

        return view;
    }

    fun getCurrentHoroscope(){
        Log.e("DailyHoroscopeFragment", horoscopePosition)
    }



}
