package com.nooro.weather_tracker.domain.repository

import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeatherData(city: String): Resource<WeatherData>
    suspend fun saveSelectedCityWeatherData(weatherData: WeatherData)
    suspend fun getSelectedCityWeatherData(): Flow<WeatherData>
}