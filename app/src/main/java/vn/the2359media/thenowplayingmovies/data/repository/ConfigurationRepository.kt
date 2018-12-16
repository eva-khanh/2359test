package vn.the2359media.thenowplayingmovies.data.repository

import io.reactivex.Observable
import vn.the2359media.thenowplayingmovies.core.PreferenceHelper
import vn.the2359media.thenowplayingmovies.data.source.ConfigurationRemoteDataSource

class ConfigurationRepository(
    val configurationRemoteDataSource: ConfigurationRemoteDataSource,
    val preferenceHelper: PreferenceHelper
) {

    fun getConfiguration(apiKey: String): Observable<Boolean> =
        configurationRemoteDataSource.getConfiguration(apiKey)
            .map { it -> it.imageConfiguration }
            .doOnNext { it ->
                preferenceHelper.imageBaseUrl = it.baseUrl
                preferenceHelper.posterSize = it.posterSizes[it.posterSizes.size - 1]
            }
            .map { true }
}