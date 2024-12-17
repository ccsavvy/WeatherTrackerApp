package com.nooro.weather_tracker.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nooro.weather_tracker.presentation.ui.composables.HomeScreen
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherTrackerAppTheme {
        HomeScreen(viewModel())
    }
}