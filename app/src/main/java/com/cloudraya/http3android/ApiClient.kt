package com.cloudraya.http3android

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.net.cronet.okhttptransport.CronetInterceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import org.chromium.net.CronetEngine
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://quic.tech:8443/"
    private lateinit var retrofit: Retrofit

    @JvmStatic
    fun getApiClient(context: Context): Retrofit {
        val cronetEngine = CronetEngine.Builder(context)
            .enableQuic(true)
            .build()

        val okHttpClient = OkHttpClient.Builder()
            .protocols(listOf(Protocol.QUIC, Protocol.HTTP_2, Protocol.HTTP_1_1))
            .addInterceptor(CronetInterceptor.newBuilder(cronetEngine).build())
            .build()

        // JSON-Modeling
        val gson = GsonBuilder()
            .setLenient()
            .create()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit
    }
}