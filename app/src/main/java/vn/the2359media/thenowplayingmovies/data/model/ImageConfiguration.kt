package vn.the2359media.thenowplayingmovies.data.model

import com.google.gson.annotations.SerializedName

data class ImageConfiguration(
    @SerializedName("base_url") val baseUrl: String,
    @SerializedName("poster_sizes") val posterSizes: List<String>
)