package vn.the2359media.thenowplayingmovies.presentation.launcher

import vn.the2359media.thenowplayingmovies.presentation.base.BaseActivity
import vn.the2359media.thenowplayingmovies.presentation.base.BaseFragment

class LauncherActivity: BaseActivity() {

    override fun getFragment(): BaseFragment = LauncherFragment.newInstance()
}