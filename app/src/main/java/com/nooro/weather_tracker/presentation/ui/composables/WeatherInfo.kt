package com.nooro.weather_tracker.presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.nooro.weather_tracker.R
import kotlin.math.roundToInt

@Composable
fun WeatherInfo(
    iconUrl: String,
    city: String,
    temperature: Double
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(11.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // Weather condition image
        AsyncImage(
            model = iconUrl,
            contentDescription = "Weather Condition Icon",
            modifier = Modifier
                .width(123.dp)
                .height(123.dp),
        )


        // City name with right arrow using ConstraintLayout
        ConstraintLayout(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            val (cityNameRef, arrowRef) = createRefs()

            Text(
                text = city,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier.constrainAs(cityNameRef) {
                    centerHorizontallyTo(parent)
                    start.linkTo(parent.start)
                }
            )

            Image(
                painter = painterResource(id = R.drawable.city_arrow),
                contentDescription = "Arrow Icon",
                modifier = Modifier
                    .size(21.dp)
                    .constrainAs(arrowRef) {
                        centerVerticallyTo(cityNameRef)
                        start.linkTo(cityNameRef.end, margin = 4.dp) // Adjust margin as needed
                    }
            )
        }


        // Temperature
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentWidth()
        ) {
            Text(
                text = "${temperature.roundToInt()}°",
                fontWeight = FontWeight.Bold,
                fontSize = 64.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}