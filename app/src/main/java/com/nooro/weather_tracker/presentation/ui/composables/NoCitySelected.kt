package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoCitySelected() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "No City Selected",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Please Search For A City",
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}