package com.nooro.weather_tracker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.util.Resource
import com.nooro.weather_tracker.presentation.ui.WeatherUiState
import com.nooro.weather_tracker.usecase.GetSelectedCityWeatherUseCase
import com.nooro.weather_tracker.usecase.GetWeatherUseCase
import com.nooro.weather_tracker.usecase.SavedSelectedCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val saveSelectedCityUseCase: SavedSelectedCityUseCase,
    private val getSelectedCityWeatherUseCase: GetSelectedCityWeatherUseCase
) : ViewModel() {

    private val _weatherState = MutableStateFlow<WeatherUiState>(WeatherUiState.NoCitySelected)
    val weatherState: StateFlow<WeatherUiState> = _weatherState

    init {
        viewModelScope.launch {
            getSavedWeatherDetails()
        }
    }

    fun searchCity(city: String) {
        if (city.isBlank()) {
            getSavedWeatherDetails()
            return
        }

        viewModelScope.launch {
            _weatherState.value = WeatherUiState.Loading

            val result = getWeatherUseCase(city)
            _weatherState.value = when (result) {
                is Resource.Success -> WeatherUiState.CityFound(
                    WeatherState(
                        city = result.data?.city ?: "",
                        temperature = result.data?.temperature ?: 0.0,
                        condition = result.data?.condition ?: "",
                        iconUrl = result.data?.iconUrl ?: "",
                        humidity = result.data?.humidity ?: 0,
                        uvIndex = result.data?.uvIndex ?: 0.0,
                        feelsLike = result.data?.feelsLike ?: 0.0
                    )
                )
                is Resource.Error -> WeatherUiState.CityNotFound
                else -> WeatherUiState.CityNotFound
            }
        }
    }

    fun selectCity(weatherState: WeatherState) {
        _weatherState.value = WeatherUiState.CitySelected(weatherState)
        viewModelScope.launch {
            saveSelectedCityUseCase(
                WeatherData(
                    city = weatherState.city,
                    temperature = weatherState.temperature,
                    condition = weatherState.condition,
                    iconUrl = weatherState.iconUrl,
                    humidity = weatherState.humidity,
                    uvIndex = weatherState.uvIndex,
                    feelsLike = weatherState.feelsLike
                )
            )
        }
    }

    private fun getSavedWeatherDetails() {
        viewModelScope.launch {
            val savedCityWeatherData = getSelectedCityWeatherUseCase.invoke().first()
            val savedCity = getSelectedCityWeatherUseCase.invoke().first().city
            if (savedCity.isNotBlank()) {
                _weatherState.value = WeatherUiState.CitySelected(
                    WeatherState(
                        city = savedCityWeatherData.city,
                        temperature = savedCityWeatherData.temperature,
                        condition = savedCityWeatherData.condition,
                        iconUrl = savedCityWeatherData.iconUrl,
                        humidity = savedCityWeatherData.humidity,
                        uvIndex = savedCityWeatherData.uvIndex,
                        feelsLike = savedCityWeatherData.feelsLike
                    )
                )
            } else {
                _weatherState.value = WeatherUiState.NoCitySelected
            }
        }
    }

}