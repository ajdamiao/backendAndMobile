package com.ajdamiao.parkspot.data.repository

import com.ajdamiao.parkspot.data.service.Service
import com.ajdamiao.parkspot.model.ParkSpot
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImp: Repository {
    private val BASEURL= "http://10.0.2.2:8080"

    override fun makeRequest(): Service {
        val client = OkHttpClient.Builder()
            .build()

        return Retrofit
            .Builder()
            .baseUrl(BASEURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)
    }

    override suspend fun getParkSpots(): ArrayList<ParkSpot> {
        return makeRequest().getParkSpots()
    }
}