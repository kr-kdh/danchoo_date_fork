package com.mvl.test

import okhttp3.Headers
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okio.Buffer
import java.util.concurrent.TimeUnit

class TestMockWebServer(
    private val adapter: ResponseAdapter
) {
    private var responseDelayMs = 0L
    private val mockWebServer: MockWebServer by lazy {
        MockWebServer().apply {
            this.dispatcher = object : Dispatcher() {
                override fun dispatch(request: RecordedRequest): MockResponse {
                    return try {
                        mockResponse(request)
                    } catch (e: Exception) {
                        errorMockResponse(ERROR_404)
                    }
                }
            }

            start()
        }
    }

    fun url(url: String) = mockWebServer.url(url)

    fun setResponseDelayMs(responseDelayMs: Long): TestMockWebServer {
        this.responseDelayMs = responseDelayMs
        return this
    }

    private fun errorMockResponse(errorCode: Int): MockResponse {
        return MockResponse()
            .setHeadersDelay(responseDelayMs, TimeUnit.MILLISECONDS)
            .setResponseCode(errorCode)
    }

    private fun errorMockResponse(request: RecordedRequest): MockResponse {
        val path = request.path ?: return errorMockResponse(ERROR_405)
        val headers = request.headers
        val body = request.body.readUtf8()

        val errorCode = adapter.onErrorResponseData(path = path, headers = headers, body = body)

        return MockResponse()
            .setHeadersDelay(responseDelayMs, TimeUnit.MILLISECONDS)
            .setResponseCode(errorCode)
    }

    private fun mockResponse(request: RecordedRequest): MockResponse {
        val path = request.path ?: return errorMockResponse(ERROR_404)
        val headers = request.headers
        val body = request.body.readUtf8()

        val responseData = when (request.method) {
            POST -> adapter.onPostResponseData(path = path, headers = headers, body = body)
            GET -> adapter.onGetResponseData(path = path, headers = headers)
            DELETE -> adapter.onDeleteResponseData(path = path, headers = headers, body = body)
            PUT -> adapter.onPutResponseData(path = path, headers = headers, body = body)
            else -> {
                return errorMockResponse(request)
            }
        }

        return MockResponse()
            .addHeader("Content-Type", "application/json")
            .setBody(
                Buffer().apply {
                    readFrom(responseData.byteInputStream(Charsets.UTF_8))
                }
            )
    }

    companion object {
        private const val POST = "POST"
        private const val GET = "GET"
        private const val DELETE = "DELETE"
        private const val PUT = "PUT"

        const val ERROR_401 = 401 // 유효한 인증 정보를 가지지 않는 경우
        const val ERROR_403 = 403 // 인증이 실패한 경우
        const val ERROR_404 = 404 // 요청한 페이지를 찾을 수 없는 경우
        const val ERROR_405 = 405 // 서버에 요청한 Methods 가 유효하지 않는 경우
    }


    interface ResponseAdapter {

        fun onPostResponseData(path: String, headers: Headers, body: String): String

        fun onGetResponseData(path: String, headers: Headers): String

        fun onDeleteResponseData(path: String, headers: Headers, body: String): String

        fun onPutResponseData(path: String, headers: Headers, body: String): String

        fun onErrorResponseData(path: String, headers: Headers, body: String): Int
    }
}