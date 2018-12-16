package vn.the2359media.thenowplayingmovies.data.source

import io.reactivex.Observable
import retrofit2.Retrofit
import vn.the2359media.thenowplayingmovies.data.ConfigClient
import vn.the2359media.thenowplayingmovies.data.response.ConfigurationResponse

class ConfigurationRemoteDataSource(retrofit: Retrofit) {
    private val configService = retrofit.create(ConfigClient::class.java)

    internal fun getConfiguration(apiKey: String): Observable<ConfigurationResponse> = configService.getConfiguration(apiKey)
}