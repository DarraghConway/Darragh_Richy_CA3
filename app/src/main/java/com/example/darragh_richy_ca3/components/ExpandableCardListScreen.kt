package com.example.darragh_richy_ca3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.darragh_richy_ca3.repository.Repository
import com.example.darragh_richy_ca3.viewmodel.MainViewModel
import com.example.darragh_richy_ca3.viewmodel.MainViewModelFactory
import com.example.darragh_richy_ca3.viewmodel.UiState
import com.example.darragh_richy_ca3.components.ExpandableCardList

@Composable
fun ExpandableCardListScreen() {
    val repository = remember { Repository() } // Initialize the Repository
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory(repository))

    val uiState by viewModel.uiState.observeAsState(UiState())

    if (uiState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (uiState.error != null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Error: ${uiState.error}")
        }
    } else {
        ExpandableCardList(cardItems = uiState.data)
    }
}
