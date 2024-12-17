package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nooro.weather_tracker.presentation.WeatherState

@Composable
fun CitySelected(weatherState: WeatherState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp) // Adding padding to the edges of the screen
    ) {

        // Weather Info on top
        WeatherInfo(
            iconUrl = weatherState.iconUrl,
            city = weatherState.city,
            temperature = weatherState.temperature
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between weather info and the card

        // Weather Info Card on bottom
        WeatherInfoCard(
            humidity = weatherState.humidity,
            uvIndex = weatherState.uvIndex,
            feelsLike = weatherState.feelsLike
        )
    }
}