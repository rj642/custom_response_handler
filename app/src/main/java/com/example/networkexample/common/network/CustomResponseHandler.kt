package com.example.networkexample.common.network

sealed interface CustomResponseHandler<T: Any>

class Loading<T: Any>: CustomResponseHandler<T>
class Success<T: Any>(val data: T?, /** Optional message and code parameter **/): CustomResponseHandler<T>
class Error<T: Any>(val message: String, val code: Int): CustomResponseHandler<T>
class ApiException<T: Any>(val e: Throwable): CustomResponseHandler<T>
