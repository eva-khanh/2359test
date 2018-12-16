package vn.the2359media.thenowplayingmovies.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import vn.the2359media.thenowplayingmovies.data.response.ConfigurationResponse

interface ConfigClient {
    @GET("configuration")
    fun getConfiguration(@Query("api_key") apiKey: String): Observable<ConfigurationResponse>
}