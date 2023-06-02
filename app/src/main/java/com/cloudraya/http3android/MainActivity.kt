package com.cloudraya.http3android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import okhttp3.Protocol
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var client: ApiInterface
    lateinit var refreshButton: Button
    lateinit var protocolTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind views
        refreshButton = findViewById(R.id.refresh_btn)
        protocolTextView = findViewById(R.id.protocol)

        refreshButton.setOnClickListener {
            doApiCall()
        }
        client = ApiClient.getApiClient(applicationContext).create(
            ApiInterface::class.java
        )

        doApiCall()
    }

    private fun doApiCall(){
        val call = client.getData()
        call.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // Handle the response
                if (response.isSuccessful) {
                    // Process the successful response
                    val protocol: Protocol = response.raw().protocol()
                    protocolTextView.text = protocol.toString()
                    if(protocol.toString() != "h2"){
                        protocolTextView.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                        protocolTextView.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.green))
                    }
                } else {
                    // Handle the error response
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // Because it is a test so we don't catch errors
            }
        })
    }
}