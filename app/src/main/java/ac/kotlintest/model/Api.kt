package ac.kotlintest.model

import ac.kotlintest.model.java.Horoscope
import retrofit2.http.GET
import retrofit2.http.Url
import rx.Observable

interface Api {

    @GET
    fun getHoroscope(@Url link:String) : Observable<Horoscope>

}