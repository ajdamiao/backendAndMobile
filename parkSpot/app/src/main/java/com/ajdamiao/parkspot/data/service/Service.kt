package com.ajdamiao.parkspot.data.service

import com.ajdamiao.parkspot.model.ParkSpot
import retrofit2.http.GET

interface Service {

    @GET("/parking-spot")
    suspend fun getParkSpots(): ArrayList<ParkSpot>
}