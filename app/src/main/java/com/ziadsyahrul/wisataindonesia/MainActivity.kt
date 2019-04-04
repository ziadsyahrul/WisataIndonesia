package com.ziadsyahrul.wisataindonesia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // configurasi retrofit
        val retrofit = Retrofit.Builder().baseUrl("http://udacoding.com/api/").addConverterFactory(GsonConverterFactory.create()).build()

        // insert config ke interface request
        val request = retrofit.create(WisataService::class.java)



        // response server
        request.getWisata().enqueue(object : Callback<ResponseServer>{
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {


                Log.d("response server", response.body()?.message)

                showData(response.body()?.data)
            }

        })


    }

    private fun showData(data: List<DataWisata>?) {
        list.adapter = data?.let { Adapter(it) }
    }
}
