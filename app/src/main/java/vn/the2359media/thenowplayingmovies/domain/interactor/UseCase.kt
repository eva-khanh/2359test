package vn.the2359media.thenowplayingmovies.domain.interactor

import io.reactivex.Observable
import vn.the2359media.thenowplayingmovies.domain.Schedulers

abstract class UseCase<in Params, Result> internal constructor(private val schedulers: Schedulers) {
    internal abstract fun buildObservable(params: Params?): Observable<Result>

    fun excute(params: Params? = null): Observable<Result> {
        return buildObservable(params)
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
    }
}