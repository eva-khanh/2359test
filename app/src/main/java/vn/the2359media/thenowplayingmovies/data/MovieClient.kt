package vn.the2359media.thenowplayingmovies.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import vn.the2359media.thenowplayingmovies.data.response.NowPlayingMovieResponse

interface MovieClient {

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("api_key") apiKey: String, @Query("page")page: Int): Observable<NowPlayingMovieResponse>
}