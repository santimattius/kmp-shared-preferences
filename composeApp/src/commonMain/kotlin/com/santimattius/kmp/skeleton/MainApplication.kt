package com.santimattius.kmp.skeleton

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.santimattius.kmp.skeleton.di.applicationModules
import com.santimattius.kmp.skeleton.features.splash.SplashScreen
import org.koin.compose.KoinApplication

@Composable
fun MainApplication() {
    KoinApplication(moduleList = { applicationModules() }) {
        Navigator(SplashScreen)
    }
}