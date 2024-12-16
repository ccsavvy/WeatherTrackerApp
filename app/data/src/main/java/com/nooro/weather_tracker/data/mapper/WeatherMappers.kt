package com.nooro.weather_tracker.data.mapper

import com.nooro.weather_tracker.domain.model.WeatherData
import com.nooro.weather_tracker.model.WeatherDto

fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        city = location.name,
        temperature = current.temp_c,
        condition = current.condition.text,
        iconUrl = "https:${current.condition.icon}",
        humidity = current.humidity,
        uvIndex = current.uv,
        feelsLike = current.feelslike_c
    )
}