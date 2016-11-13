package ac.kotlintest.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "horo", strict = false)
class DailyHoroscope{
    @set:Element(name = "aries")
    var aries:Aries? = null

    fun getAriesToday() : String? = aries!!.today

    //No matching get method for public final void ac.kotlintest.model.DailyHoroscope.setAries(ac.kotlintest.model.Aries) in class ac.kotlintest.model.DailyHoroscope
}

@Root(name = "aries", strict = false)
class Aries {
    @set:Element(name = "today")
    var today:String? = null
}

