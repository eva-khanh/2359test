package vn.the2359media.thenowplayingmovies.data.source

import io.reactivex.Observable
import retrofit2.Retrofit
import vn.the2359media.thenowplayingmovies.data.MovieClient
import vn.the2359media.thenowplayingmovies.data.response.NowPlayingMovieResponse

class NowPlayingRemoteDataSource(retrofit: Retrofit) {
    private val moviesService = retrofit.create(MovieClient::class.java)

    internal fun getNowPlayingMovie(apiKey: String, page: Int): Observable<NowPlayingMovieResponse> {
        return moviesService.getNowPlayingMovies(apiKey, page)
    }
}