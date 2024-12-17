package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.nooro.weather_tracker.presentation.WeatherState

@Composable
fun CityFound(onCitySelected: () -> Unit, weatherState: WeatherState) {
    Box {
        SearchResultCard(
            weatherState = weatherState,
            onClick = onCitySelected
        )
    }
}