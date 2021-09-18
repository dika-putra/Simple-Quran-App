package com.dika.quranapp.data.common

import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return Result.error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            Timber.e(e)
            return when (e) {
                is ConnectException -> {
                    Result.error(CONNECT_EXCEPTION)
                }
                is UnknownHostException -> {
                    Result.error(UNKNOWN_HOST_EXCEPTION)
                }
                is SocketTimeoutException -> {
                    Result.error(SOCKET_TIME_OUT_EXCEPTION)
                }
                is HttpException -> {
                    Result.error(UNKNOWN_NETWORK_EXCEPTION)
                }
                else -> {
                    Result.error(UNKNOWN_NETWORK_EXCEPTION)
                }
            }
        }
    }
}
