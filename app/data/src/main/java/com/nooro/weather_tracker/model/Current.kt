package com.nooro.weather_tracker.model

data class Current(
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val temp_c: Double,
    val uv: Double
)
