package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.model.pojo.HoroscopeItem
import ac.kotlintest.until.UntilH
import ac.kotlintest.view.activities.MainActivity
import ac.kotlintest.view.adapters.ChooseYourHorAdapter
import ac.kotlintest.view.presenters.ChooseYourHorPresenter
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.choose_your_horoscope.*
import kotlinx.android.synthetic.main.choose_your_horoscope.view.*
import java.util.*

class ChooseYourHor : Fragment(){

    var until: UntilH = UntilH()
    var listHoroscope: ArrayList<HoroscopeItem>? = null
    var chooseYourHorPresenter: ChooseYourHorPresenter? = null
    var arrayAdapter: ChooseYourHorAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.choose_your_horoscope, container, false)

        chooseYourHorPresenter = ChooseYourHorPresenter()
        listHoroscope = chooseYourHorPresenter!!.generationHoroscope()
        arrayAdapter = ChooseYourHorAdapter(context, R.layout.item_choose_horo, listHoroscope!!)
        view.choose_horoscope.adapter = arrayAdapter

        view.choose_horoscope.setOnItemClickListener { adapterView, view, i, l ->
            if(until.isConnect(activity)){
                (activity as MainActivity).setItemHoroscopePosition(i)
                (activity as MainActivity).nextPage()
                (activity as MainActivity).getDailyHoroscope()
            } else {
                Snackbar.make(main_container, getString(R.string.check_internet), Snackbar.LENGTH_SHORT).show()
            }
        }

        return view;
    }
}
