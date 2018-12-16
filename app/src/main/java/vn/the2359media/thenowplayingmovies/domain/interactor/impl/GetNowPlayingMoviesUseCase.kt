package vn.the2359media.thenowplayingmovies.domain.interactor.impl

import io.reactivex.Observable
import vn.the2359media.thenowplayingmovies.data.model.NowPlayingMovie
import vn.the2359media.thenowplayingmovies.data.repository.NowPlayingRepository
import vn.the2359media.thenowplayingmovies.domain.Schedulers
import vn.the2359media.thenowplayingmovies.domain.interactor.UseCase

class GetNowPlayingMoviesUseCase(
    scheduler: Schedulers,
    val nowPlayingRepository: NowPlayingRepository
) : UseCase<Pair<String, Int>, List<NowPlayingMovie>>(scheduler) {
    override fun buildObservable(params: Pair<String, Int>?): Observable<List<NowPlayingMovie>> {
        if (params == null) {
            throw IllegalArgumentException("Params is null")
        }
        val (apiKey, page) = params
        return nowPlayingRepository.getNowPlayingMovie(apiKey, page)
    }
}