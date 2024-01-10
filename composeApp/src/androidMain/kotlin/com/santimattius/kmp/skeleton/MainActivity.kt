package com.santimattius.kmp.skeleton

import App
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.skeleton.core.ui.components.getDataStore
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(androidPlatformModules(LocalContext.current))
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

fun androidModule(context: Context) = module {
    single<DataStore<Preferences>> {
        getDataStore(context)
    }
}

fun androidPlatformModules(context: Context) = listOf(androidModule(context))

