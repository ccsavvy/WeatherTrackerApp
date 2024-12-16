package com.nooro.weather_tracker.domain.repository

import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(city: String): Resource<WeatherData>
    suspend fun saveSelectedCity(city: String)
    suspend fun getSelectedCity(): String?
}