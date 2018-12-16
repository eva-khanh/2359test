package vn.the2359media.thenowplayingmovies.presentation

import vn.the2359media.thenowplayingmovies.core.PreferenceHelper

class ConfigChecker(val preferenceHelper: PreferenceHelper) {

    fun hasConfig() = preferenceHelper.imageBaseUrl != null
}