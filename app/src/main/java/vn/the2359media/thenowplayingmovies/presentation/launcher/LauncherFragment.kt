package vn.the2359media.thenowplayingmovies.presentation.launcher

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.core.ext.viewModel
import vn.the2359media.thenowplayingmovies.presentation.ConfigChecker
import vn.the2359media.thenowplayingmovies.presentation.base.BaseFragment
import vn.the2359media.thenowplayingmovies.presentation.home.HomeActivity
import javax.inject.Inject

class LauncherFragment : BaseFragment() {
    companion object {
        fun newInstance(): LauncherFragment {
            return LauncherFragment()
        }
    }

    @Inject
    lateinit var configChecker: ConfigChecker
    private lateinit var launcherViewModel: LauncherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launcherViewModel = viewModel(viewModelFactory) {
            error.observe(this@LauncherFragment, Observer {
                notify(it!!)
            })
            loadConfigSuccess.observe(this@LauncherFragment, Observer {
                if (it!!)
                    navigateToHome()
                else
                    notifyWithAction(
                        R.string.error_loading_config_fail,
                        R.string.action_finish
                    ) {
                        activity!!.finish()
                    }
            })
        }
    }

    override fun layoutId(): Int = R.layout.fragment_launcher

    override fun onResume() {
        super.onResume()
        if (configChecker.hasConfig()) {
            navigateToHome()
        } else {
            val apiKey = context!!.getString(R.string.tmdb_apiKey)
            launcherViewModel.getConfiguration(apiKey)
        }
    }

    override fun onStop() {
        super.onStop()
        launcherViewModel.clear()
    }

    private fun navigateToHome() {
        val homeIntent = HomeActivity.newIntent(context!!)
        homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(homeIntent)
    }
}