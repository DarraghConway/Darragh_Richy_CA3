package com.example.darragh_richy_ca3


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.darragh_richy_ca3.viewmodel.UiState

@Composable
fun NavGraph(navController: NavHostController, uiState: UiState) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MainScreen(navController = navController, uiState = uiState)
        }
        composable("details/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            val cardItem = uiState.data.find { it.id.toString() == itemId }
            DetailScreen(navController = navController, itemId = itemId, cardItem = cardItem)
        }
    }
}
