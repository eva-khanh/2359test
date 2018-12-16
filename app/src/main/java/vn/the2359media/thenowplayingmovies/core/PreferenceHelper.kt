package vn.the2359media.thenowplayingmovies.core

import android.content.Context

class PreferenceHelper(context: Context) {
    companion object {
        private const val PREFERENCE_NAME = "themovies.pref"

        private const val IMAGE_BASE_URL = "base_url"
        private const val POSTER_SIZE = "poster_size"
    }

    private val sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    var imageBaseUrl: String?
        get() = sharedPreferences.getString(IMAGE_BASE_URL, null)
        set(value) = sharedPreferences.edit().putString(IMAGE_BASE_URL, value).apply()

    var posterSize: String?
        get() = sharedPreferences.getString(POSTER_SIZE, null)
        set(value) = sharedPreferences.edit().putString(POSTER_SIZE, value).apply()
}