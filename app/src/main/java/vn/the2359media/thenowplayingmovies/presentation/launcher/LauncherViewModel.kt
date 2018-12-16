package vn.the2359media.thenowplayingmovies.presentation.launcher

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import vn.the2359media.thenowplayingmovies.domain.interactor.impl.GetConfigUseCase
import vn.the2359media.thenowplayingmovies.presentation.base.BaseViewModel

class LauncherViewModel(private val configurationUseCase: GetConfigUseCase, context: Context): BaseViewModel(context.applicationContext as Application) {
    val loadConfigSuccess = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    internal fun getConfiguration(apiKey: String) {
        addDisposable(getConfigurationDisposable(apiKey))
    }

    private fun getConfigurationDisposable(apiKey: String): Disposable {
        return configurationUseCase.excute(apiKey)
            .subscribeWith(object : DisposableObserver<Boolean>() {
                override fun onComplete() {
                }

                override fun onNext(isSuccess: Boolean) {
                    loadConfigSuccess.value = isSuccess
                }

                override fun onError(e: Throwable) {
                    error.value = e.localizedMessage
                }
            })
    }
}