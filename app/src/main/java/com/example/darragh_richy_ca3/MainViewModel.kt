// MainViewModel.kt
package com.example.darragh_richy_ca3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.darragh_richy_ca3.model.CardItem
import com.example.darragh_richy_ca3.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers

data class UiState(
    val isLoading: Boolean = false,
    val data: List<CardItem> = emptyList(),
    val error: String? = null
)

class MainViewModel : ViewModel() {
    val uiState = liveData(Dispatchers.IO) {
        emit(UiState(isLoading = true))
        try {
            val response = RetrofitInstance.api.getData().execute()
            emit(UiState(data = response.body() ?: emptyList()))
        } catch (e: Exception) {
            emit(UiState(error = e.message))
        }
    }
}
