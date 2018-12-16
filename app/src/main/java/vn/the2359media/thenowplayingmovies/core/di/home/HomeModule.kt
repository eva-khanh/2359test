package vn.the2359media.thenowplayingmovies.core.di.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import dagger.Module
import dagger.Provides
import vn.the2359media.thenowplayingmovies.data.repository.NowPlayingRepository
import vn.the2359media.thenowplayingmovies.domain.Schedulers
import vn.the2359media.thenowplayingmovies.domain.interactor.impl.GetNowPlayingMoviesUseCase
import vn.the2359media.thenowplayingmovies.presentation.home.HomeViewModel

@Module
internal class HomeModule {
    @Provides
    internal fun provideGetNowPlayingMovieUseCase(schedulers: Schedulers, nowPlayingRepository: NowPlayingRepository) =
        GetNowPlayingMoviesUseCase(schedulers, nowPlayingRepository)


    @Provides
    internal fun provideViewModelFactory(
        context: Context,
        getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return when {
                    modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                        HomeViewModel(getNowPlayingMoviesUseCase, context) as T
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            }
        }
    }

}