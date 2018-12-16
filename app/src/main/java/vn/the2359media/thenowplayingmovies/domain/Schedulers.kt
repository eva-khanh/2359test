package vn.the2359media.thenowplayingmovies.domain

import io.reactivex.Scheduler

interface Schedulers {
    val subscribeOn: Scheduler

    val observeOn: Scheduler
}