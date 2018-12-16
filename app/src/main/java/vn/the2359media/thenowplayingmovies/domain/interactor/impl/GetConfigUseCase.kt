package vn.the2359media.thenowplayingmovies.domain.interactor.impl

import io.reactivex.Observable
import vn.the2359media.thenowplayingmovies.data.repository.ConfigurationRepository
import vn.the2359media.thenowplayingmovies.domain.Schedulers
import vn.the2359media.thenowplayingmovies.domain.interactor.UseCase

class GetConfigUseCase(schedulers: Schedulers, val configurationRepository: ConfigurationRepository): UseCase<String, Boolean>(schedulers) {
    override fun buildObservable(params: String?): Observable<Boolean> {
        if (params == null) {
            throw IllegalArgumentException("API Key is required")
        }
        return configurationRepository.getConfiguration(params)
    }
}