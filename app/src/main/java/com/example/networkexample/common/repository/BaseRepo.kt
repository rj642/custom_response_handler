package com.example.networkexample.common.repository

import com.example.networkexample.common.network.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import retrofit2.Response

open class BaseRepo {

    protected suspend inline fun<T: Any> makeRequest(
        crossinline request: suspend () -> CustomResponseHandler<T>
    ) = flow {

        emit(Loading())

        when (val res = request.invoke()) {
            is Success -> {
                emit(Success(res.data))
            }
            is Error -> {
                emit(Error(res.message, res.code))
            }
            is ApiException -> {
                emit(ApiException(res.e))
            }
            else -> {}
        }

    }.flowOn(Dispatchers.IO)

}