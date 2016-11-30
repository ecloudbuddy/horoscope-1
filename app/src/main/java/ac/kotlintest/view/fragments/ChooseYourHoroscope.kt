package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.view.activities.HoroscopeSettings
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ChooseYourHoroscope : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome_old, container, false)

        return view;
    }

    fun clickItemHoroscope(v: View?) {
        (activity as HoroscopeSettings).setItemHoroscopePosition(v!!.tag.toString())
        (activity as HoroscopeSettings).nextPage()
        (activity as HoroscopeSettings).getCurrentHoroscope()
    }

}
