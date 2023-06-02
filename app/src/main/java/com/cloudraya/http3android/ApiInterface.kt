package com.cloudraya.http3android

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    // get rwquest
    @GET("/")
    fun getData(): Call<ResponseBody>
}