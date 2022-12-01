package com.ajdamiao.parkspot.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajdamiao.parkspot.data.Resource.Outcome
import com.ajdamiao.parkspot.data.states.GetAllParkSpotsState
import com.ajdamiao.parkspot.data.usecase.GetAllParkSpotsUseCase
import com.ajdamiao.parkspot.model.ParkSpot
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(private val getAllParkSpotsUseCase: GetAllParkSpotsUseCase): ViewModel() {
    private val _parkSpots = MutableLiveData<GetAllParkSpotsState>()
    val parkSpots: LiveData<GetAllParkSpotsState> = _parkSpots

    fun getParkSpots() {
        getAllParkSpotsUseCase().onEach { result ->
            when(result) {
                is Outcome.Success -> { _parkSpots.value = GetAllParkSpotsState(parkSpots = result.data ?: ArrayList()) }
                is Outcome.Progress -> { _parkSpots.value = GetAllParkSpotsState(isLoading = true) }
                is Outcome.Progress -> { _parkSpots.value = GetAllParkSpotsState(error = result.message ?: "An unexpected error occurred") }
            }
        }.launchIn(viewModelScope)
    }
}