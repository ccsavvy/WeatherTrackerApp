package com.nooro.weather_tracker.data.repository

import com.nooro.weather_tracker.data.local.WeatherLocalDataSource
import com.nooro.weather_tracker.data.mapper.toWeatherData
import com.nooro.weather_tracker.data.remote.WeatherRemoteDataSource
import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.domain.repository.WeatherRepository
import com.nooro.weather_tracker.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
    private val weatherLocalDataSource: WeatherLocalDataSource
) : WeatherRepository {

    override suspend fun getWeatherData(city: String): Resource<WeatherData> {
        return when (val result = weatherRemoteDataSource.getWeather(city)) {
            is Resource.Success -> {
                try {
                    val weatherData = result.data?.toWeatherData()
                    Resource.Success(weatherData)
                } catch (e: Exception) {
                    Resource.Error(e.message)
                }
            }

            is Resource.Error -> {
                Resource.Error(result.message)
            }
        }
    }

    override suspend fun saveSelectedCityWeatherData(weatherData: WeatherData) {
        weatherLocalDataSource.saveSelectedCityWeatherData(weatherData)
    }

    override suspend fun getSelectedCityWeatherData(): Flow<WeatherData> = weatherLocalDataSource.getSelectedCityWeatherData()

}