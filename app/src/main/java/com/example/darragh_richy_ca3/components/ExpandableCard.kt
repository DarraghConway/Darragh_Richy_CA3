package com.example.darragh_richy_ca3.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.imageLoader
import com.example.darragh_richy_ca3.model.CardItem
import com.example.darragh_richy_ca3.viewmodel.MainViewModel
import com.example.darragh_richy_ca3.viewmodel.UiState

@Composable
fun ExpandableCardList(cardItems: List<CardItem>) {
    val expandedCardIds = remember { mutableStateOf(mutableMapOf<Int, Boolean>()) }

    LazyColumn {
        items(cardItems) { cardItem ->
            // Check if specific card is expanded
            val isExpanded = expandedCardIds.value[cardItem.id] ?: false

            Log.d("ExpandableCardList", "Rendering card with ID: ${cardItem.id}, isExpanded: $isExpanded")

            ExpandableCard(
                cardItem = cardItem,
                isExpanded = isExpanded,
                onExpandToggle = { expanded ->
                    expandedCardIds.value = expandedCardIds.value.toMutableMap().apply {
                        // Close other cards that are expanded
                        keys.forEach { key -> put(key, false) }
                        put(cardItem.id, expanded)
                    }
                    Log.d("ExpandableCard", "Card with ID: ${cardItem.id} expanded: $expanded")
                },
                onButtonClick = { cardId ->
                    Log.d("ExpandableCard", "Button clicked for card ID: $cardId")
                }
            )
        }
    }
}

@Composable
fun ExpandableCard(
    cardItem: CardItem,
    isExpanded: Boolean,
    onExpandToggle: (Boolean) -> Unit,
    onButtonClick: (Int) -> Unit
) {
    var backgroundColor by remember { mutableStateOf(Color.White) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor) // Apply the background color
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Log.d("ExpandableCard", "Card clicked with ID: ${cardItem.id}, current expanded state: $isExpanded")
                    onExpandToggle(!isExpanded)
                }
                .padding(16.dp)
        ) {
            // Image
            AsyncImage(
                model = cardItem.image_url,
                contentDescription = "${cardItem.common_name} Image",
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                imageLoader = LocalContext.current.imageLoader.newBuilder()
                    .crossfade(true)
                    .build(),
                onState = {
                    when (it) {
                        is AsyncImagePainter.State.Loading -> Log.d("ExpandableCard", "Image loading for card ID: ${cardItem.id}")
                        is AsyncImagePainter.State.Success -> Log.d("ExpandableCard", "Image loaded successfully for card ID: ${cardItem.id}")
                        is AsyncImagePainter.State.Error -> Log.d("ExpandableCard", "Image loading error for card ID: ${cardItem.id}")
                        else -> Unit
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Common Name
            Text(
                text = cardItem.common_name ?: "No common name available", // Handle nullability
            )

            // Scientific Name
            Text(
                text = cardItem.scientific_name,
            )

            // Description (Expanded state)
            if (isExpanded) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Plant stats go here",
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    backgroundColor = if (backgroundColor == Color.White) Color.Gray else Color.White
                    onButtonClick(cardItem.id)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Change Colour")
            }
        }
    }
}



