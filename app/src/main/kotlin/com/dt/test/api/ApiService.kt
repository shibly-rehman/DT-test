package com.dt.test.api

import com.dt.test.model.ProductAds
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit api calls interface.
 */
interface ApiService {

    /**
     * Call to get product ads
     */
    @GET("getAds")
    fun getProductAds(
        @Query("id") id: String = "236",
        @Query("password") password: String = "OVUJ1DJN",
        @Query("siteId") siteId: String = "10777",
        @Query("deviceId") deviceId: String = "4230",
        @Query("sessionId") sessionId: String = "techtestsession",
        @Query("totalCampaignsRequested") totalCampaignsRequested: Int = 10,
        @Query("lname") lastName: String = "Rehman"
    ): Call<ProductAds>
}