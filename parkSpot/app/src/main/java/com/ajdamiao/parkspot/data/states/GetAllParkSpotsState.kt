package com.ajdamiao.parkspot.data.states

import com.ajdamiao.parkspot.model.ParkSpot

data class GetAllParkSpotsState (
    val isLoading: Boolean = false,
    val parkSpots: ArrayList<ParkSpot> = ArrayList(),
    val error: String = ""
)