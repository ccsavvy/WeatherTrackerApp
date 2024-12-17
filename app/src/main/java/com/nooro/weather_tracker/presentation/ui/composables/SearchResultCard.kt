package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nooro.weather_tracker.presentation.WeatherState
import com.nooro.weather_tracker.presentation.ui.theme.lightGray
import kotlin.math.max
import kotlin.math.roundToInt

@Composable
fun SearchResultCard(
    weatherState: WeatherState,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(117.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = lightGray,
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = weatherState.city,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(8.dp)) // Add spacing between city and temperature
                Text(
                    text = "${weatherState.temperature.roundToInt()}°",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 40.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

            AsyncImage(
                model = weatherState.iconUrl,
                contentDescription = "Weather Condition Icon",
                modifier = Modifier
                    .size(83.dp, 183.dp)
            )
        }
    }
}