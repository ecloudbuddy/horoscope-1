package ac.kotlintest.model

import ac.kotlintest.model.java.Horoscope
import retrofit2.http.GET
import rx.Observable

interface Api {

    @GET("r/export/utf/xml/daily/com.xml")
    fun getDailyHoroscope() : Observable<Horoscope>

    @GET("r/export/utf/xml/daily/ero.xml")
    fun getEroHoroscope() : Observable<Horoscope>

    @GET("r/export/utf/xml/daily/anti.xml")
    fun getAntiHoroscope() : Observable<Horoscope>

    @GET("r/export/utf/xml/daily/bus.xml")
    fun getBusinessHoroscope() : Observable<Horoscope>

    @GET("r/export/utf/xml/daily/hea.xml")
    fun getHealHoroscope() : Observable<Horoscope>

    @GET("r/export/utf/xml/daily/cook.xml")
    fun getCookHoroscope() : Observable<Horoscope>

    @GET("r/export/utf/xml/daily/lov.xml")
    fun getLoveHoroscope() : Observable<Horoscope>

}