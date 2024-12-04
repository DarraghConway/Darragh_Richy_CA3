package com.example.darragh_richy_ca3.repository

import com.example.darragh_richy_ca3.model.CardItem
import com.example.darragh_richy_ca3.network.RetrofitInstance

class Repository {
    private val token = "IdKi-I0NoMqLT0TDg2iwcMdk0TcWmSQOJA3Puc_qNvI"

    suspend fun fetchPlants(): List<CardItem> {
        val response = RetrofitInstance.api.getPlants(token).execute()
        if (response.isSuccessful) {
            return response.body()?.data ?: emptyList()
        } else {
            throw Exception("Error: ${response.code()} - ${response.message()}")
        }
    }
}
