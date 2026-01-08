package com.wsircam.taskmanagement.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wsircam.taskmanagement.models.DayModel

@Composable
fun CalendarDay(dayName: String, dayNumber: Int) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .height(70.dp)
            .width(50.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(dayName, style = MaterialTheme.typography.bodySmall)
            Text(dayNumber.toString())
        }
    }
}

@Composable
fun CalendarCarousel(
    currentWeek: List<DayModel>
) {
    Row {
        currentWeek.forEach { currentDay ->
            CalendarDay(currentDay.dayName, currentDay.dayNumber.toInt())
        }
    }
}

@Composable
@Preview
fun CalendarDayPreview() {
    CalendarDay("Thu", 15)
}

@Composable
@Preview
fun CalendarCarouselPreview() {
    CalendarCarousel(
        listOf(
            DayModel(dayName = "Sun", dayNumber = 12),
            DayModel(dayName = "Mon", dayNumber = 13),
            DayModel(dayName = "Wed", dayNumber = 14),
            DayModel(dayName = "Wed", dayNumber = 15),
            DayModel(dayName = "Thu", dayNumber = 16),
            DayModel(dayName = "Fri", dayNumber = 17),
            DayModel(dayName = "Sat", dayNumber = 18),
        )
    )
}
