package com.santimattius.kmp.skeleton.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.santimattius.kmp.skeleton.core.ui.components.AppBar

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<HomeScreenModel>()
        HomeScreenContent(screenModel)
    }
}

@Composable
fun HomeScreenContent(
    screenModel: HomeScreenModel,
) {
    val state by screenModel.uiState.collectAsState()
    Scaffold(
        topBar = { AppBar(title = "DataStore") },
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Counter value", style = MaterialTheme.typography.displaySmall)
                Text("${state.data}", style = MaterialTheme.typography.displayMedium)
                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(enabled = state.data > 0, onClick = { screenModel.desc() }) {
                        Icon(Icons.Default.Remove, contentDescription = null)
                    }
                    Button(onClick = { screenModel.inc() }) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                }
            }
        }
    }
}
