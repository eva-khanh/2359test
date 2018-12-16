package vn.the2359media.thenowplayingmovies.domain

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class AppScheduler : Schedulers {
    override val subscribeOn: Scheduler = io.reactivex.schedulers.Schedulers.io()
    override val observeOn: Scheduler = AndroidSchedulers.mainThread()
}