package com.example.darragh_richy_ca3.components


import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.darragh_richy_ca3.model.CardItem

@Composable
fun ResponsiveCardList(cardItems: List<CardItem>) {
    BoxWithConstraints {
        val screenWidth = maxWidth
        if (screenWidth < 600.dp) {
            LazyColumn {
                items(cardItems) { cardItem ->
                    ExpandableCard(
                        cardItem = cardItem,
                        isExpanded = false,
                        onExpandToggle = { },
                        onButtonClick = { }
                    )
                }
            }
        } else {
            LazyRow {
                items(cardItems) { cardItem ->
                    ExpandableCard(
                        cardItem = cardItem,
                        isExpanded = false,
                        onExpandToggle = { },
                        onButtonClick = {  }
                    )
                }
            }
        }
    }
}
