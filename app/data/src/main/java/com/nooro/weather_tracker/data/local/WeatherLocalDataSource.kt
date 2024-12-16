package com.nooro.weather_tracker.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class WeatherLocalDataSource @Inject constructor(
    private val dataSource: DataStore<Preferences>
) {

    companion object {
        val SELECTED_CITY_KEY = stringPreferencesKey("selected_city")
    }

    suspend fun saveSelectedCity(city: String) {
        dataSource.edit { preferences ->
            preferences[SELECTED_CITY_KEY] = city
        }
    }

    suspend fun getSelectedCity(): String? {
        val preferences = dataSource.data.first()
        return preferences[SELECTED_CITY_KEY]
    }
}