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

    open fun getDailyHoroscope() {
        appModule!!.provideApi().getDailyHoroscope()
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

    open fun getEroHoroscope(){
        appModule!!.provideApi().getEroHoroscope()
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

    open fun getAntiHoroscope(){
        appModule!!.provideApi().getEroHoroscope()
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

    open fun getBusHoroscope(){
        appModule!!.provideApi().getBusinessHoroscope()
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

    open fun getHealfHoroscope(){
        appModule!!.provideApi().getHealHoroscope()
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

    open fun getCookHoroscope(){
        appModule!!.provideApi().getCookHoroscope()
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

    open fun getLoveHoroscope(){
        appModule!!.provideApi().getLoveHoroscope()
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