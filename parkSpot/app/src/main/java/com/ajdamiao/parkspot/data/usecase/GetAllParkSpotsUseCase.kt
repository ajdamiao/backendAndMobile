package com.ajdamiao.parkspot.data.usecase

import com.ajdamiao.parkspot.data.Resource.Outcome
import com.ajdamiao.parkspot.data.repository.RepositoryImp
import com.ajdamiao.parkspot.model.ParkSpot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetAllParkSpotsUseCase(private val repository: RepositoryImp) {

    operator fun invoke(): Flow<Outcome<ArrayList<ParkSpot>>> = flow {
        try {
            emit(Outcome.Progress())
            val response = repository.getParkSpots()
            emit(Outcome.Success(response))
        } catch (exception: HttpException) {
            emit(Outcome.Failure(exception.message()))
        }
    }
}