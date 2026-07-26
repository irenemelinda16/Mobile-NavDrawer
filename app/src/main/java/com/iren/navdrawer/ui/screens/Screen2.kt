package com.iren.navdrawer.ui.screens

import androidx.compose.runtime.Composable

@Composable
fun Screen2(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 2",
        contentText = "This is the content area for Screen 2",
        onBackClick = onBackClick
    )
}
