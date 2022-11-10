package com.assanali.whether2

import android.app.DownloadManager.Request
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.assanali.whether2.databinding.ActivityMainBinding

const val API_KEY = "f505eb698c734e45b7a51806221011"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.bGet.setOnClickListener{
            getResult("Toronto")
        }
    }
    private fun getResult(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
                  "?key=$API_KEY&q=$name&aqi=no"

        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(com.android.volley.Request.Method.GET,
            url,
            {
                    response->
                Log.d("MyLog", "Response: $response")
            },
            {
                Log.d("MyLog" , "Volley error: $it")
            }
            )
        queue.add(stringRequest)
    }
}