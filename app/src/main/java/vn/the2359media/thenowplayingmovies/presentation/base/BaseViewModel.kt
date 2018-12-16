package vn.the2359media.thenowplayingmovies.presentation.base

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected val context: WeakReference<Context>
    private val disposables = CompositeDisposable()

    init {
        context = WeakReference(application)
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    fun clear() {
        disposables.clear()
    }
}