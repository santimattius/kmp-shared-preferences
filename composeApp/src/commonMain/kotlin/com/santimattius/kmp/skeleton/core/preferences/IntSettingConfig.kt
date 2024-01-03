package com.santimattius.kmp.skeleton.core.preferences

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.coroutines.getIntFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class IntSettingConfig(settings: Settings, key: String, defaultValue: Int) :
    SettingConfig<Int>(settings, key, defaultValue) {

    @OptIn(ExperimentalSettingsApi::class)
    override val value: Flow<Int>
        get() {
            val observableSettings = settings as? ObservableSettings ?: return emptyFlow()
            return observableSettings.getIntFlow(key, defaultValue)
        }

    override fun getStringValue(settings: Settings, key: String, defaultValue: Int): String =
        settings.getInt(key, defaultValue).toString()

    override fun setStringValue(settings: Settings, key: String, value: String) =
        settings.putInt(key, value.toInt())
}