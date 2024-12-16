package com.nooro.weather_tracker.usecase

import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.repository.WeatherRepository
import com.nooro.weather_tracker.domain.util.Resource
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) {

    suspend operator fun invoke(city: String): Resource<WeatherData> {
        return try {
            val weatherData = weatherRepository.getWeatherData(city)
            if (weatherData is Resource.Success && weatherData.data != null
                && weatherData.data.city.isNotBlank()
                && weatherData.data.city.equals(city, ignoreCase = true)
            ) {
                Resource.Success(weatherData.data)
            } else {
                Resource.Error("City not found or invalid response")
            }
        } catch (e: Exception) {
            Resource.Error("Failed to fetch weather data: ${e.message}")
        }
    }
}