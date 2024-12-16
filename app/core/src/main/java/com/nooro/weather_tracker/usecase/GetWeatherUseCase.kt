package com.nooro.weather_tracker.usecase

import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.repository.WeatherRepository
import com.nooro.weather_tracker.domain.util.Resource
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
){

    suspend fun invoke(city: String): Resource<WeatherData> {
        return weatherRepository.getWeatherData(city)
    }
}