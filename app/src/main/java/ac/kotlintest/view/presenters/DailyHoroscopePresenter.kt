package ac.kotlintest.view.presenters

import ac.kotlintest.model.java.DailyHoroscopeJ
import ac.kotlintest.modules.AppModule
import android.util.Log
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class DailyHoroscopePresenter {
    var appModule : AppModule? = null
    init {
        appModule = AppModule();
    }

    open fun getDailyHoroscope() {
        appModule!!.provideApi().getTodayHoroscope()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<DailyHoroscopeJ>() {
                    override fun onError(e: Throwable?) {
                        Log.e("error", e.toString())
                        throw UnsupportedOperationException("not implemented")
                    }

                    override fun onCompleted() {}

                    override fun onNext(dailyHoroscope : DailyHoroscopeJ) {
                        var today : String? = dailyHoroscope.getAriesToday()
                        Log.e("today", today)
                    }
                })
    }

}