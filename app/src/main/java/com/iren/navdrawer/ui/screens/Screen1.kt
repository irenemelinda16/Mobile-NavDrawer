package com.iren.navdrawer.ui.screens

import androidx.compose.runtime.Composable

@Composable
fun Screen1(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 1",
        contentText = "This is the content area for Screen 1",
        onBackClick = onBackClick
    )
}
