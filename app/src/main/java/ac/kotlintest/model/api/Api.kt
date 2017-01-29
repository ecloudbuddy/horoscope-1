package ac.kotlintest.model.api

import ac.kotlintest.model.pojo.Horoscope
import retrofit2.http.GET
import retrofit2.http.Url
import rx.Observable

interface Api {

    @GET
    fun getHoroscope(@Url link:String) : Observable<Horoscope>

}