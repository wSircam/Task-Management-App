package com.wsircam.taskmanagement

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wsircam.taskmanagement.models.DayModel
import com.wsircam.taskmanagement.ui.CalendarCarousel
import com.wsircam.taskmanagement.ui.MainBottomBar
import com.wsircam.taskmanagement.ui.MainDrawer
import com.wsircam.taskmanagement.ui.MainTopBar
import com.wsircam.taskmanagement.ui.theme.TaskManagementTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagementTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainDrawer()
                }
            }
        }
    }
}

@Composable
fun MainContainer(scope: CoroutineScope, drawerState: DrawerState) {
    Scaffold(
        topBar = {
            MainTopBar {
                scope.launch { drawerState.open() }
            }
        },
        bottomBar = {
            MainBottomBar()
        },
        modifier = Modifier.systemBarsPadding(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Icon(Icons.Default.Add, null)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { innerPadding ->
        Greeting(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 0.dp)
    ) {
        Text(
            text = stringResource(R.string.home_title),
            style = MaterialTheme.typography.titleLarge,
        )
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
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun GreetingDarkPreview() {
    TaskManagementTheme(
        dynamicColor = false,
    ) {
        MainDrawer()
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun GreetingPreview() {
    TaskManagementTheme(
        dynamicColor = false,
    ) {
        MainDrawer()
    }
}
