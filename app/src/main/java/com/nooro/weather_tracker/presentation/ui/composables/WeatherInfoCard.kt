package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nooro.weather_tracker.R
import com.nooro.weather_tracker.presentation.ui.theme.lightGray
import kotlin.math.roundToInt

@Composable
fun WeatherInfoCard(
    humidity: Int,
    uvIndex: Double,
    feelsLike: Double
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), // Ensure the Box takes up the full screen
        contentAlignment = Alignment.Center // Align the content to the center of the Box
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(75.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = lightGray
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Humidity",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "UV",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "Feels Like",
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${humidity}%",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "${uvIndex.roundToInt()}",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "${feelsLike.roundToInt()}".plus(stringResource(R.string.degree_text)),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}