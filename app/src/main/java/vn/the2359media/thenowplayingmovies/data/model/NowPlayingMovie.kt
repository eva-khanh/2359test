package vn.the2359media.thenowplayingmovies.data.model

import com.google.gson.annotations.SerializedName

data class NowPlayingMovie(
    @SerializedName("id") val id: Int,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("poster_path") val posterPath: String
)