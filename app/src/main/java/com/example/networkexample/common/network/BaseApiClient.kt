package com.example.networkexample.common.network

import retrofit2.HttpException
import retrofit2.Response

open class BaseApiClient {

    protected suspend inline fun<T: Any> getResult (
        crossinline request: suspend () -> Response<T>
    ) = try {
        val response = request.invoke()
        if (response.isSuccessful && response.body() != null) {
            Success(response.body())
        } else {
            Error(response.message(), response.code())
        }
    } catch (e: HttpException) {
        Error(e.message(), e.code())
    } catch (e: Throwable) {
        ApiException(e)
    }

}