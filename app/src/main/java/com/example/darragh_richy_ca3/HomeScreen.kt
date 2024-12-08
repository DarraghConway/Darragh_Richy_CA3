package com.example.darragh_richy_ca3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.darragh_richy_ca3.components.ResponsiveCardList
import com.example.darragh_richy_ca3.model.CardItem
import com.example.darragh_richy_ca3.repository.Repository
import com.example.darragh_richy_ca3.ui.theme.Darragh_Richy_CA3Theme
import com.example.darragh_richy_ca3.viewmodel.MainViewModel
import com.example.darragh_richy_ca3.viewmodel.MainViewModelFactory
import com.example.darragh_richy_ca3.viewmodel.UiState

@Composable
fun HomeScreen(navController: NavHostController) {
    val repository = Repository()
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory(repository))
    val uiState by viewModel.uiState.observeAsState(initial = UiState(isLoading = true))

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            uiState.isLoading -> CircularProgressIndicator()
            uiState.error != null -> Text(text = "Error: ${uiState.error}")
            else -> ResponsiveCardList(
                cardItems = uiState.data,
                onItemClick = { cardItem ->
                    navController.navigate("details/${cardItem.id}")
                }
            )
        }
    }
}
