package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.business.ConfigurationConstants.ARTIST_IDS
import com.eferraz.shufflesongs.business.ConfigurationConstants.LIMIT_OF_SONGS
import com.eferraz.shufflesongs.data.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("lookup")
    fun getSongs(
        @Query("id") id: String = ARTIST_IDS,
        @Query("limit") limit: Int = LIMIT_OF_SONGS
    ): Call<DataResponse>
}
