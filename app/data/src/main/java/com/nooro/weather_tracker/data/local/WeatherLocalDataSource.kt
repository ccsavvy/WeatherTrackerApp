package com.nooro.weather_tracker.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.nooro.weather_tracker.domain.model.WeatherData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherLocalDataSource @Inject constructor(
    private val dataSource: DataStore<Preferences>
) {

    suspend fun saveSelectedCityWeatherData(weatherData: WeatherData) {
        dataSource.edit { preferences ->
            preferences[stringPreferencesKey("city")] = weatherData.city
            preferences[doublePreferencesKey("temperature")] = weatherData.temperature
            preferences[stringPreferencesKey("condition")] = weatherData.condition
            preferences[stringPreferencesKey("iconUrl")] = weatherData.iconUrl
            preferences[intPreferencesKey("humidity")] = weatherData.humidity
            preferences[doublePreferencesKey("uvIndex")] = weatherData.uvIndex
            preferences[doublePreferencesKey("feelsLike")] = weatherData.feelsLike
        }
    }

    fun getSelectedCityWeatherData(): Flow<WeatherData> {
        return dataSource.data.map { preferences ->
            WeatherData(
                city = preferences[stringPreferencesKey("city")] ?: "",
                temperature = preferences[doublePreferencesKey("temperature")] ?: 0.0,
                condition = preferences[stringPreferencesKey("condition")] ?: "",
                iconUrl = preferences[stringPreferencesKey("iconUrl")] ?: "",
                humidity = preferences[intPreferencesKey("humidity")] ?: 0,
                uvIndex = preferences[doublePreferencesKey("uvIndex")] ?: 0.0,
                feelsLike = preferences[doublePreferencesKey("feelsLike")] ?: 0.0
            )
        }
    }
}