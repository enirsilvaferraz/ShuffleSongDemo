package com.eferraz.shufflesongs.business

import com.eferraz.shufflesongs.data.DataResponse
import com.eferraz.shufflesongs.data.Song
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SongRepositoryRemoteImpl(private val api: ApiService) : SongRepository {

    override suspend fun getSongs() =
        suspendCoroutine<List<Song>> { continuation ->

            api.getSongs().enqueue(object : Callback<DataResponse> {

                override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(
                    call: Call<DataResponse>,
                    response: Response<DataResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        continuation.resume(response.body()!!.results)
                    } else {
                        continuation.resumeWithException(Exception(response.message()))
                    }
                }
            })
        }
}
