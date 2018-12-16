package vn.the2359media.thenowplayingmovies.data.repository

import io.reactivex.Observable
import vn.the2359media.thenowplayingmovies.data.model.NowPlayingMovie
import vn.the2359media.thenowplayingmovies.data.source.NowPlayingRemoteDataSource

class NowPlayingRepository(val nowPlayingRemoteDataSource: NowPlayingRemoteDataSource) {

    fun getNowPlayingMovie(apiKey: String, page: Int): Observable<List<NowPlayingMovie>> = nowPlayingRemoteDataSource.getNowPlayingMovie(apiKey, page).map { it -> it.movies }
}