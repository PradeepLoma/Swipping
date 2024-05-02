package com.example.testpusher.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun loginBuilder() {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
            .clipToBounds()
            .clip(shape = RoundedCornerShape(6.dp))
    ) {

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "Simple Edit Text",
            onValueChange = {

            }, trailingIcon = {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "Check")
            })

    }
}

@Preview
@Composable
fun showPreviewLogin() {
    loginBuilder()
}