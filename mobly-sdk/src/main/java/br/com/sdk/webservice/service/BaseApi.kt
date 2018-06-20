package br.com.sdk.webservice.service

import br.com.sdk.utils.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class BaseApi{
    val service: MoblyApiRest
    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val gson = GsonBuilder().setLenient().create()

        val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging).build()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Constants.DOMAIN_URL)
                .client(client)
                .build()
        service = retrofit.create<MoblyApiRest>(MoblyApiRest::class.java)
    }
}