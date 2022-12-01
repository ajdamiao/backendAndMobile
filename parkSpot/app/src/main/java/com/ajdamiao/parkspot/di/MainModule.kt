package com.ajdamiao.dalabolt.di

import com.ajdamiao.parkspot.data.repository.RepositoryImp
import com.ajdamiao.parkspot.data.usecase.GetAllParkSpotsUseCase
import com.ajdamiao.parkspot.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single { RepositoryImp() }
    single { GetAllParkSpotsUseCase( get() ) }

    viewModel {
        HomeViewModel(
            get()
        )
    }
}