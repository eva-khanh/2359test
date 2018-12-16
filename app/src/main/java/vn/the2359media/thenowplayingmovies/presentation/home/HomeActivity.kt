package vn.the2359media.thenowplayingmovies.presentation.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.presentation.base.BaseActivity
import vn.the2359media.thenowplayingmovies.presentation.base.BaseFragment

class HomeActivity : BaseActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.now_playing)
    }

    override fun getFragment(): BaseFragment = HomeFragment.newInstance()
}