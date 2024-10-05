package com.jetbrains.kmpapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jetbrains.kmpapp.screens.detail.DetailScreen
import com.jetbrains.kmpapp.screens.list.ListScreen
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalDateTime.*
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable

import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Duration.Companion.days


@Serializable
object ListDestination

@Serializable
data class DetailDestination(val objectId: Int)

@Composable
fun App() {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors() else lightColors()
    ) {

            HomeScreen()

        }

    }

    @Composable
    fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
        Text(
            text = from,
            fontSize = 25.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            modifier = modifier


        )


        Text(
            text = message,
            fontSize = 40.sp,
            color = Color.Red,
            modifier = Modifier
                .padding(16.dp)

        )

    }


    @Composable
    fun BirthdayCardPreview() {

        GreetingText(message = "Happy Birthday Sam!", from = "From Emma")

    }
    fun DayAdder( days: Int): String {

        var ndate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

        var localDate = ndate.plus(days,DateTimeUnit.DAY)



        return "${localDate.monthNumber.toString().padStart(2, '0')}-${localDate.dayOfMonth.toString().padStart(2, '0')}-${localDate.year}"
    }
    @Composable
    fun HomeScreen(){
        var qdog = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        var calcium = qdog.date






        Column {
            Spacer(modifier = Modifier.padding(30.dp))

            GreetingText(
            message =  DayAdder(28).toString(),
            from = "28 Days  ",

            )

            GreetingText(
                message = DayAdder(30).toString(),
                from = "30 Days",

                )

            GreetingText(
                message = DayAdder(60).toString(),
                from = "60 Days",

                )

            GreetingText(
                message = DayAdder(90).toString(),
                from = "90 Days",

                )

            GreetingText(
                message = DayAdder(180).toString(),
                from = "180 Days",

                )
    }

}
