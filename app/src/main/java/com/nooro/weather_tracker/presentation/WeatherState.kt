package com.nooro.weather_tracker.presentation

data class WeatherState(
    val city: String,
    val temperature: Double,
    val condition: String,
    val iconUrl: String,
    val humidity: Int,
    val uvIndex: Double,
    val feelsLike: Double,
    val isLoading: Boolean = false,
) {
    override fun toString(): String =
        "WeatherState(city='$city', temperature=$temperature," +
                " condition='$condition', iconUrl='$iconUrl', " +
                "humidity=$humidity, uvIndex=$uvIndex, feelsLike=$feelsLike," +
                " isLoading=$isLoading)"
}
