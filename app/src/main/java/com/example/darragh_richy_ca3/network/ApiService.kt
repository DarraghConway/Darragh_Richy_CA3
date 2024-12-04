// ApiService.kt
package com.example.darragh_richy_ca3.network

import com.example.darragh_richy_ca3.model.CardItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/plant/search")
    fun getData(): Call<List<CardItem>>
}
