package com.nooro.weather_tracker.data.remote

import com.nooro.weather_tracker.domain.util.Resource
import com.nooro.weather_tracker.model.WeatherDto
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi
) {

    private val API_KEY = "bfea2337c7184e91b4e123529241312"

    suspend fun getWeather(city: String): Resource<WeatherDto> {
        return try {
            val response = weatherApi.getWeather(API_KEY, city)
            if (response.isSuccessful) {
                val weatherDto = response.body()
                Resource.Success(weatherDto)
            } else {
                Resource.Error("API request failed: ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}