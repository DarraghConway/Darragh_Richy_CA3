package com.example.darragh_richy_ca3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.darragh_richy_ca3.components.ExpandableCardListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableCardListScreen()
            FallingLeafAnimation()
        }
    }
}
