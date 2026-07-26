package com.iren.navdrawer.ui.screens

import androidx.compose.runtime.Composable

@Composable
fun Screen3(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Screen 3",
        contentText = "This is the content area for Screen 3",
        onBackClick = onBackClick
    )
}
