package com.nooro.weather_tracker.data.repository

import com.nooro.weather_tracker.data.local.WeatherLocalDataSource
import com.nooro.weather_tracker.data.remote.WeatherRemoteDataSource
import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.repository.WeatherRepository
import com.nooro.weather_tracker.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherLocalDataSource: WeatherLocalDataSource
) : WeatherRepository {

    override suspend fun getWeatherData(city: String): Resource<WeatherData> {
        TODO("Not yet implemented")
    }

    override suspend fun saveSelectedCity(city: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getSelectedCity(): String? {
        TODO("Not yet implemented")
    }

}