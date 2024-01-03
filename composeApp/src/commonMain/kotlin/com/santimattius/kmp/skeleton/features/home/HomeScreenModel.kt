package com.santimattius.kmp.skeleton.features.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.santimattius.kmp.skeleton.core.data.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


data class HomeUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val data: Int = 0,
)

class HomeScreenModel(
    private val settingsRepository: SettingsRepository,
) : StateScreenModel<HomeUiState>(HomeUiState()) {

    val uiState = settingsRepository.counter.map { HomeUiState(data = it) }.stateIn(
        scope = screenModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeUiState(),
    )

    fun desc() = settingsRepository.decrease()


    fun inc() = settingsRepository.increment()
}
