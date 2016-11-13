package ac.kotlintest.view.fragments

import ac.kotlintest.R
import ac.kotlintest.view.activities.HoroscopeSettings
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class ChooseYourHoroscope : Fragment() {

    var image : ImageView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        view.findViewById(R.id.button).setOnClickListener { (activity as HoroscopeSettings).previewNextPage(1) }
        image = view.findViewById(R.id.scorpio) as ImageView?

        applyBlur()

        return view;
    }

    fun applyBlur() {
        image!!.viewTreeObserver.addOnPreDrawListener {
            (activity as HoroscopeSettings).blur(image!!)
            true
        }
    }


}
