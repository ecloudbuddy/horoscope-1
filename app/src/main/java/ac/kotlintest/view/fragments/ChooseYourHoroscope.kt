package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.view.activities.HoroscopeSettings
import ac.kotlintest.view.until.UntilH
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_welcome_old.*

class ChooseYourHoroscope : Fragment(){

    var until : UntilH = UntilH()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome_old, container, false)

        return view;
    }

    fun clickItemHoroscope(v: View?) {
        if(until.isConnect(activity)){
            (activity as HoroscopeSettings).setItemHoroscopePosition(v!!.tag.toString())
            (activity as HoroscopeSettings).nextPage()
            (activity as HoroscopeSettings).getCurrentHoroscope()
        } else
            Snackbar.make(main_container, getString(R.string.check_internet), Snackbar.LENGTH_SHORT).show()
    }

}
