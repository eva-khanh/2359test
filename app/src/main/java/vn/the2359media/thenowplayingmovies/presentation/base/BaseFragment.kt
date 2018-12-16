package vn.the2359media.thenowplayingmovies.presentation.base

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.toolbar.*
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.core.ext.appContext
import vn.the2359media.thenowplayingmovies.core.ext.viewContainer
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {
    abstract fun layoutId(): Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

    open fun onBackPressed() {}

    internal fun showProgress() = progressStatus(View.VISIBLE)

    internal fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) { if (this is BaseActivity) this.progressbar.visibility = viewStatus }

    internal fun notify(@StringRes message: Int) =
        Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

    internal fun notify(message: String) =
        Snackbar.make(viewContainer, message, Snackbar.LENGTH_SHORT).show()

    internal fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) {
        val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
        snackBar.setAction(actionText) { _ -> action.invoke() }
        snackBar.setActionTextColor(
            ContextCompat.getColor(
                appContext,
                R.color.colorTextPrimary
            )
        )
        snackBar.show()
    }
}