package com.danchoo.retrofitutils

import android.util.Log
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.Buffer
import java.io.IOException

class HttpInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .build()

        val response = chain.proceed(request)

        if (!PRINT_LOG) {
            return response
        }

        response.body?.let {
            val source = it.source()
            source.request(Long.MAX_VALUE) // Buffer the entire body.

            printStartLog(request.url)

            printRequestBody(request)
            printResponse(source.buffer)

            printEndLog()
        }

        return response
    }

    private fun printStartLog(url: HttpUrl) {
        Log.d(TAG, "response : === $url start =======")
        Log.d(TAG, "response : ============= request header =========")
    }

    private fun printRequestBody(request: Request) {
        try {
            val copy = request.newBuilder().build()
            copy.body?.let { requestBody ->
                val requestBodyBuffer = Buffer()
                requestBody.writeTo(requestBodyBuffer)
                Log.d(TAG, "response request body: ${requestBodyBuffer.readUtf8()}")
            }

        } catch (e: IOException) {
        }
    }

    private fun printResponse(buffer: Buffer) {
        Log.d(TAG, "response : =========== response =======")
        val json = buffer.clone().readString(charset("UTF-8"))
        Log.d(TAG, "response : $json")
    }

    private fun printEndLog() {
        Log.d(TAG, "response : ==================== end ===================")
    }

    companion object {
        const val TAG: String = "HttpInterceptor"
        const val PRINT_LOG = true
    }
}