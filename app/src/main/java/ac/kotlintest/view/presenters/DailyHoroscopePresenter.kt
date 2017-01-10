package ac.kotlintest.view.presenters

import ac.kotlintest.model.java.Horoscope
import ac.kotlintest.modules.AppModule
import android.util.Log
import org.greenrobot.eventbus.EventBus
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

open class DailyHoroscopePresenter {
    var appModule : AppModule? = null
    init {
        appModule = AppModule()
    }

    open fun getHoroscope(link : String) {
        appModule!!.provideApi().getHoroscope(link)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : Subscriber<Horoscope>() {
                    override fun onError(e: Throwable?) {
                        Log.e("error", e.toString())
                        throw UnsupportedOperationException("not implemented")
                    }

                    override fun onCompleted() {}

                    override fun onNext(horoscope: Horoscope) {
                        EventBus.getDefault().post(horoscope)
                    }
                })
    }

}