package com.santimattius.kmp.skeleton.core.ui.components

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.skeleton.core.datastore.dataStoreFileName
import com.santimattius.kmp.skeleton.core.datastore.getDataStore as createDataStore

fun getDataStore(context: Context): DataStore<Preferences> = createDataStore(
    producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
)