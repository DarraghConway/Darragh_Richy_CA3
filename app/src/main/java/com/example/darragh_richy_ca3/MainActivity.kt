package com.example.darragh_richy_ca3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.darragh_richy_ca3.components.ExpandableCardList
import com.example.darragh_richy_ca3.model.CardItem
import com.example.darragh_richy_ca3.ui.theme.Darragh_Richy_CA3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Darragh_Richy_CA3Theme {
                val viewModel: MainViewModel = viewModel()
                val uiState by viewModel.uiState.observeAsState(initial = UiState(isLoading = true))

                MainScreen(uiState = uiState)
            }
        }
    }
}

@Composable
fun MainScreen(uiState: UiState) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator()
            }
            uiState.error != null -> {
                Text(text = "Error: ${uiState.error}")
            }
            else -> {
                ExpandableCardList(cardItems = uiState.data)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    Darragh_Richy_CA3Theme {
        MainScreen(
            uiState = UiState(
                isLoading = false,
                data = listOf(
                    CardItem(id = 1, title = "Plant 1", imageUrl = "https://example.com/plant1.jpg"),
                    CardItem(id = 2, title = "Plant 2", imageUrl = "https://example.com/plant2.jpg")
                ),
                error = null
            )
        )
    }
}
