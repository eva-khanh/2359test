package vn.the2359media.thenowplayingmovies.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.core.ext.inTransaction

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        addFragment()
    }

    private fun addFragment() = supportFragmentManager.inTransaction { add(R.id.fragmentContainer, getFragment()) }

    abstract fun getFragment(): BaseFragment
}