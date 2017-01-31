package ac.kotlintest.view.presenters

import ac.kotlintest.R
import ac.kotlintest.model.pojo.Horoscope
import ac.kotlintest.model.pojo.HoroscopeInfItem
import ac.kotlintest.modules.AppModule
import android.content.Context
import android.util.Log
import org.greenrobot.eventbus.EventBus
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.*

open class InfAboutYourHorPresenter(context: Context) {
    var appModule : AppModule? = null
    var context: Context? = null
    init {
        this.appModule = AppModule()
        this.context = context
    }

    open fun getHoroscope(link : String) {
        appModule!!.provideApi().getHoroscope(link)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Subscriber<Horoscope>() {
                    override fun onError(e: Throwable?) {
                        Log.e("error", e.toString())
                        EventBus.getDefault().post(e.toString())
                        //throw UnsupportedOperationException("not implemented")
                    }

                    override fun onCompleted() {}

                    override fun onNext(horoscope: Horoscope) {
                        EventBus.getDefault().post(generationListHoro(horoscope))
                    }
                })
    }

    open fun generationListHoro(horoscope: Horoscope) : ArrayList<HoroscopeInfItem> {
        var listInfHoroscope: ArrayList<HoroscopeInfItem> = ArrayList()
        
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.aries, context!!.getString(R.string.aries), horoscope.ariesYesterday, horoscope.ariesToday, horoscope.arieTomorrow, horoscope.ariesTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.taurus, context!!.getString(R.string.taurus), horoscope.taurusYesterday, horoscope.taurusToday, horoscope.taurusTomorrow, horoscope.taurusTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.gemini, context!!.getString(R.string.gemini), horoscope.geminiYesterday, horoscope.geminiToday, horoscope.geminiTomorrow, horoscope.geminiTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.cancer, context!!.getString(R.string.cancer), horoscope.cancerYesterday, horoscope.cancerToday, horoscope.cancerTomorrow, horoscope.cancerTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.leo, context!!.getString(R.string.leo), horoscope.leoYesterday, horoscope.leoToday, horoscope.leoTomorrow, horoscope.leoTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.virgo, context!!.getString(R.string.virgo), horoscope.virgoYesterday, horoscope.virgoToday, horoscope.virgoTomorrow, horoscope.virgoTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.libra, context!!.getString(R.string.libra), horoscope.libraYesterday, horoscope.libraToday, horoscope.libraTomorrow, horoscope.libraTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.scorpio, context!!.getString(R.string.scorpio), horoscope.scorpioYesterday, horoscope.scorpioToday, horoscope.scorpioTomorrow, horoscope.scorpioTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.sagittarius, context!!.getString(R.string.sagittarius), horoscope.sagittariusYesterday, horoscope.sagittariusToday, horoscope.sagittariusTomorrow, horoscope.sagittariusTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.capricorn, context!!.getString(R.string.capricorn), horoscope.capricornYesterday, horoscope.capricornToday, horoscope.capricornTomorrow, horoscope.cancerTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.capricorn, context!!.getString(R.string.aquarius), horoscope.aquariusYesterday, horoscope.aquariusToday, horoscope.aquariusTomorrow, horoscope.aquariusTomorrow02))
        listInfHoroscope.add(HoroscopeInfItem(R.drawable.pisces, context!!.getString(R.string.pisces), horoscope.piscesYesterday, horoscope.piscesToday, horoscope.piscesTomorrow, horoscope.piscesTomorrow02))

        return listInfHoroscope
    }
}