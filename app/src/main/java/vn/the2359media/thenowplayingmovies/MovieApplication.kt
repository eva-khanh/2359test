package vn.the2359media.thenowplayingmovies

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import vn.the2359media.thenowplayingmovies.core.di.DaggerAppComponent

class MovieApplication: DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().create(this)
}