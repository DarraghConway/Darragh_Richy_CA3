//package com.example.darragh_richy_ca3
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.offset
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.rememberInfiniteTransition
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun FallingLeafAnimation() {
//    val infiniteTransition = rememberInfiniteTransition()
//    val offsetY by infiniteTransition.animateFloat(
//        initialValue = -200f,
//        targetValue = 800f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(durationMillis = 5000, easing = LinearEasing),
//            repeatMode = RepeatMode.Restart
//        )
//    )
//
//    Image(
//        painter = painterResource(id = R.drawable.ic_leaf),
//        contentDescription = "Falling Leaf",
//        modifier = Modifier
//            .offset(y = offsetY.dp)
//            .fillMaxWidth()
//    )
//}
