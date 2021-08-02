package com.dt.test.api

import com.dt.test.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Configurations for retrofit.
 */
object ApiFactory {

    val api: ApiService = createApiService()

    /**
     * Create Api service object.
     */
    private fun createApiService(): ApiService {

        // okHttp
        val okHttpClient = createHttpBuilder().build()

        // XML parser
        // SimpleXmlConverter deprecated but alternative not available on android
        val xmlConverter = SimpleXmlConverterFactory.create()

        // retrofit
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(Constants.API_URL)
            .addConverterFactory(xmlConverter)
            .client(okHttpClient)

        return retrofitBuilder.build().create(ApiService::class.java)
    }

    private fun createHttpBuilder () = OkHttpClient().newBuilder().readTimeout(300, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS)
}