package com.santimattius.kmp.skeleton.core.data

import com.russhwolf.settings.Settings
import com.santimattius.kmp.skeleton.core.preferences.IntSettingConfig
import kotlinx.coroutines.flow.Flow

class SettingsRepository(
    settings: Settings,
) {


    private val _counter = IntSettingConfig(settings, "counter", 0)
    val counter: Flow<Int> = _counter.value

    fun increment() {
        val value = _counter.get().toInt() + 1
        _counter.set("$value")
    }

    fun decrease() {
        val value = _counter.get().toInt() - 1
        if (value < 0) {
            _counter.set("0")
        } else {
            _counter.set("$value")
        }
    }
}