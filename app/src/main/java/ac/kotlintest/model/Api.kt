package ac.kotlintest.model

import ac.kotlintest.model.java.DailyHoroscopeJ
import retrofit2.http.GET
import rx.Observable

interface Api {

    @GET("r/export/utf/xml/daily/com.xml")
    fun getTodayHoroscope() : Observable<DailyHoroscopeJ>

}