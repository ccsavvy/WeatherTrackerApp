package com.nooro.weather_tracker.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.nooro.weather_tracker.data.local.WeatherLocalDataSource
import com.nooro.weather_tracker.data.remote.WeatherApi
import com.nooro.weather_tracker.data.remote.WeatherRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    @Singleton
    fun provideWeatherLocalDataSource(dataStore: DataStore<Preferences>): WeatherLocalDataSource =
        WeatherLocalDataSource(dataStore)

    @Provides
    @Singleton
    fun provideWeatherRemoteDataSource(weatherApi: WeatherApi) = WeatherRemoteDataSource(weatherApi)

}