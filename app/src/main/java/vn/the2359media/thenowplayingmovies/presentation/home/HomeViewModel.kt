package vn.the2359media.thenowplayingmovies.presentation.home

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import io.reactivex.observers.DisposableObserver
import vn.the2359media.thenowplayingmovies.data.model.NowPlayingMovie
import vn.the2359media.thenowplayingmovies.domain.interactor.impl.GetNowPlayingMoviesUseCase
import vn.the2359media.thenowplayingmovies.presentation.base.BaseViewModel

class HomeViewModel(private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase, context: Context) :
    BaseViewModel(context.applicationContext as Application) {
    val listMovies = MutableLiveData<List<NowPlayingMovie>>()
    val error = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    private var page = 1

    internal fun getNowPlayingMovies(apiKey: String) {
        addDisposable(getNowPlayingMoviesUseCase.excute(Pair(apiKey, page))
            .subscribeWith(object : DisposableObserver<List<NowPlayingMovie>>() {
                override fun onStart() {
                    loading.value = true
                }

                override fun onComplete() {
                }

                override fun onNext(movies: List<NowPlayingMovie>) {
                    loading.value = false
                    listMovies.value = movies
                    page++
                }

                override fun onError(e: Throwable) {
                    loading.value = false
                    error.value = e.localizedMessage
                }
            })
        )
    }

    internal fun stop() {
        clear()
    }
}