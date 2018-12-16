package vn.the2359media.thenowplayingmovies.data.response

import com.google.gson.annotations.SerializedName
import vn.the2359media.thenowplayingmovies.data.model.NowPlayingMovie

data class NowPlayingMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<NowPlayingMovie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResult: Int
)