// MainViewModel.kt
package com.example.darragh_richy_ca3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.darragh_richy_ca3.model.CardItem
import com.example.darragh_richy_ca3.repository.Repository
import kotlinx.coroutines.Dispatchers

data class UiState(
    val isLoading: Boolean = false,
    val data: List<CardItem> = emptyList(),
    val error: String? = null
)

class MainViewModel(private val repository: Repository) : ViewModel() {
    val uiState = liveData(Dispatchers.IO) {
        emit(UiState(isLoading = true))
        try {
            val plants = repository.fetchPlants()
            emit(UiState(data = plants))
        } catch (e: Exception) {
            emit(UiState(error = e.message))
        }
    }
}

