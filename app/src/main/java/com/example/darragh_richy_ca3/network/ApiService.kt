package com.example.darragh_richy_ca3.network

import com.example.darragh_richy_ca3.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("plants")
    fun getPlants(
        @Query("token") token: String
    ): Call<ApiResponse> // Return ApiResponse instead of List<CardItem>
}
