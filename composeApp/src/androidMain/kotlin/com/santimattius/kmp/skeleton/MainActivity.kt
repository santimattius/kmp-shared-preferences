package com.santimattius.kmp.skeleton

import App
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.preference.PreferenceManager
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val preferences = PreferenceManager.getDefaultSharedPreferences(LocalContext.current)
            App(androidPlatformModules(preferences))
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}

fun androidModule(sharedPref: SharedPreferences) = module {
    single<Settings> {
        SharedPreferencesSettings(sharedPref)
    }
}

fun androidPlatformModules(sharedPref: SharedPreferences) = listOf(androidModule(sharedPref))

