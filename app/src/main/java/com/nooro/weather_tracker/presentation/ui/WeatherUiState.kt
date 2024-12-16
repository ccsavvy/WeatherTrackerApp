package com.nooro.weather_tracker.presentation.ui

import com.nooro.weather_tracker.presentation.WeatherState

sealed interface WeatherUiState {
    data object Loading : WeatherUiState
    data object NoCitySelected : WeatherUiState
    data class CityFound(val weather: WeatherState) : WeatherUiState
    data object CityNotFound : WeatherUiState
    data class CitySelected(val weather: WeatherState) : WeatherUiState
}