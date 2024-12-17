package com.nooro.weather_tracker.presentation.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.nooro.weather_tracker.presentation.WeatherViewModel
import com.nooro.weather_tracker.presentation.ui.WeatherUiState

@Composable
fun HomeScreen(
    viewModel: WeatherViewModel
) {
    val uiState by viewModel.weatherState.collectAsState()
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .focusRequester(focusRequester)

    ) {
        SearchBar({ city ->
            viewModel.searchCity(city)
        }, focusRequester)

        when (uiState) {
            is WeatherUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is WeatherUiState.CityFound -> {
                CityFound(onCitySelected = {
                    viewModel.selectCity((uiState as WeatherUiState.CityFound).weather)
                }, weatherState = (uiState as WeatherUiState.CityFound).weather)
                Log.d(
                    "HomeScreen",
                    "City weather data found ${(uiState as WeatherUiState.CityFound).weather}}"
                )
            }

            WeatherUiState.CityNotFound -> {
                // Display an empty screen when there is no city found
                Spacer(modifier = Modifier.fillMaxSize())
                Log.d("HomeScreen", "City not found")
            }

            is WeatherUiState.CitySelected -> {
                Spacer(Modifier.height(32.dp))
                CitySelected((uiState as WeatherUiState.CitySelected).weather)
                Log.d(
                    "HomeScreen",
                    "City selected: ${(uiState as WeatherUiState.CitySelected).weather.city}"
                )
            }

            WeatherUiState.NoCitySelected -> {
                NoCitySelected()
                Log.d("HomeScreen", "No city selected")
            }
        }
    }
}