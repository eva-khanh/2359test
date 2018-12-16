package vn.the2359media.thenowplayingmovies.core.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vn.the2359media.thenowplayingmovies.MovieApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ApplicationModule::class,
        DataModule::class
    ]
)
internal interface AppComponent : AndroidInjector<MovieApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MovieApplication>()
}