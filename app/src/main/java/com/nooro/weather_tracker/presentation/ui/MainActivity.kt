package com.nooro.weather_tracker.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nooro.weather_tracker.presentation.WeatherViewModel
import com.nooro.weather_tracker.presentation.ui.theme.WeatherTrackerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTrackerAppTheme {
                HomeScreen(viewModel = viewModel())
            }
        }
    }
}

@Composable
fun HomeScreen(
    viewModel: WeatherViewModel
) {
    val uiState by viewModel.weatherState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SearchBar { city ->
            viewModel.searchCity(city)
        }

        when (uiState) {
            is WeatherUiState.Loading -> CircularProgressIndicator()
            is WeatherUiState.CityFound -> Log.d("HomeScreen", "City weather data found ${(uiState as WeatherUiState.CityFound).weather}}")
            WeatherUiState.CityNotFound -> Log.d("HomeScreen", "City not found")
            is WeatherUiState.CitySelected -> Log.d("HomeScreen", "City selected: ${(uiState as WeatherUiState.CitySelected).weather.city}")
            WeatherUiState.NoCitySelected -> Log.d("HomeScreen", "No city selected")
        }
    }
}

@Composable
fun SearchBar(
    onSearch: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = { searchText = it },
        label = { Text("Search City") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search"
            )
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(searchText)
            }
        )
    )
}

@Composable
fun SearchResultCard(
    city: String,
    onCitySelected: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onCitySelected(city) }
    ) {
        Text(
            text = city,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherTrackerAppTheme {
        HomeScreen(viewModel())
    }
}