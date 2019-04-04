package com.ziadsyahrul.wisataindonesia

import retrofit2.Call
import retrofit2.http.GET

interface WisataService {

    @GET("?action=findAll")
    fun getWisata() : Call<ResponseServer>



}