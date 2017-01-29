package ac.kotlintest.view.presenters

import ac.kotlintest.model.pojo.HoroscopeItem
import java.util.*

open class ChooseYourHorPresenter {

    open fun generationHoroscope() : ArrayList<HoroscopeItem> {
        var listHoroscope : ArrayList<HoroscopeItem> = ArrayList()
        listHoroscope.add(HoroscopeItem("aries"))
        listHoroscope.add(HoroscopeItem("taurus"))
        listHoroscope.add(HoroscopeItem("gemini"))
        listHoroscope.add(HoroscopeItem("cancer"))
        listHoroscope.add(HoroscopeItem("leo"))
        listHoroscope.add(HoroscopeItem("virgo"))
        listHoroscope.add(HoroscopeItem("libra"))
        listHoroscope.add(HoroscopeItem("scorpio"))
        listHoroscope.add(HoroscopeItem("sagittarius"))
        listHoroscope.add(HoroscopeItem("capricorn"))
        listHoroscope.add(HoroscopeItem("aquarius"))
        listHoroscope.add(HoroscopeItem("pisces"))

        return listHoroscope
    }
}