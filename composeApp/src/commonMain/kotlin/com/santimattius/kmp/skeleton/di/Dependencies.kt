package com.santimattius.kmp.skeleton.di

import com.santimattius.kmp.skeleton.core.data.PictureRepository
import com.santimattius.kmp.skeleton.core.network.ktorHttpClient
import com.santimattius.kmp.skeleton.features.home.HomeScreenModel
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module

val sharedModules = module {
    single(qualifier(AppQualifiers.BaseUrl)) { "https://api-picture.onrender.com" }
    single(qualifier(AppQualifiers.Client)) {
        ktorHttpClient(
            baseUrl = get(
                qualifier = qualifier(
                    AppQualifiers.BaseUrl
                )
            )
        )
    }

    single { PictureRepository(get(qualifier(AppQualifiers.Client))) }
}

val homeModule = module {
    factory { HomeScreenModel(repository = get()) }
}


fun applicationModules() = listOf(sharedModules, homeModule)