package com.santimattius.kmp.skeleton.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepository(
    private val dataStore: DataStore<Preferences>,
) {


    private val _counterKey = intPreferencesKey("counter")
    val counter: Flow<Int> = dataStore.data.map { it[_counterKey]?.toInt() ?: 0 }

    suspend fun increment() {
        dataStore.edit {
            val value = it[_counterKey] ?: 0
            it[_counterKey] = value + 1
        }
    }

    suspend fun decrease() {
        dataStore.edit {
            val value = (it[_counterKey] ?: 0) - 1
            it[_counterKey] = if (value < 0) 0 else value
        }
    }
}