package com.ajdamiao.parkspot.data.repository

import com.ajdamiao.parkspot.data.service.Service
import com.ajdamiao.parkspot.model.ParkSpot

interface Repository {
    fun makeRequest(): Service

    suspend fun getParkSpots(): ArrayList<ParkSpot>

}