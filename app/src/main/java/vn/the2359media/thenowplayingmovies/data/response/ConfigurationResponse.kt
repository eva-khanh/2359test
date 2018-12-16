package vn.the2359media.thenowplayingmovies.data.response

import com.google.gson.annotations.SerializedName
import vn.the2359media.thenowplayingmovies.data.model.ImageConfiguration

data class ConfigurationResponse(
    @SerializedName("images") val imageConfiguration: ImageConfiguration,
    @SerializedName("change_keys") val changeKeys: List<String>
)