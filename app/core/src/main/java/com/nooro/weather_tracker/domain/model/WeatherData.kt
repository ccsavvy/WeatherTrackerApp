package com.nooro.weather_tracker.domain.model

data class WeatherData (
    val city: String,
    val temperature: Double,
    val condition: String,
    val iconUrl: String,
    val humidity: Int,
    val uvIndex: Double,
    val feelsLike: Double
)