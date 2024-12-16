package com.nooro.weather_tracker.usecase

import android.util.Log
import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.repository.WeatherRepository
import javax.inject.Inject

class SavedSelectedCityUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {

    companion object {
        const val TAG = "SavedSelectedCityUseCase"
    }

    suspend operator fun invoke(weatherData: WeatherData) {
        try {
            weatherRepository.saveSelectedCityWeatherData(weatherData)
        } catch (e: Exception) {
            // Handle the exception
            Log.e(TAG, "Failed to save selected city: ${weatherData.city}")
        }
    }
}