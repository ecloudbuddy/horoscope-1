package ac.kotlintest.modules

import ac.kotlintest.model.api.Api
import ac.kotlintest.until.LogInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

open class AppModule {

    val BASE_URL : String = "http://img.ignio.com/"
    var retrofit : Retrofit? = null

    open fun provideApi() : Api {
        if(retrofit == null){
            val logging = LogInterceptor()
            var httpClient = OkHttpClient.Builder()
            //httpClient.addInterceptor(logging)
            httpClient.readTimeout(10, TimeUnit.SECONDS)
            httpClient.connectTimeout(10, TimeUnit.SECONDS)

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(httpClient.build())
                    .build()
        }

        return retrofit!!.create(Api::class.java)
    }

}
