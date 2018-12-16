package vn.the2359media.thenowplayingmovies.presentation.home

import android.arch.lifecycle.Observer
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.core.PreferenceHelper
import vn.the2359media.thenowplayingmovies.core.ext.SpacesItemDecoration
import vn.the2359media.thenowplayingmovies.core.ext.viewModel
import vn.the2359media.thenowplayingmovies.data.model.NowPlayingMovie
import vn.the2359media.thenowplayingmovies.presentation.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var moviesListAdapter: MoviesListAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    private var spanCount = 2
    private var isLoading = false
    private lateinit var apiKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context?.let { apiKey = context!!.getString(R.string.tmdb_apiKey) }
        homeViewModel = viewModel(viewModelFactory) {
            error.observe(this@HomeFragment, Observer {
                notify(it!!)
            })
            listMovies.observe(this@HomeFragment, Observer {
                updateListMovies(it!!)
            })
            loading.observe(this@HomeFragment, Observer {
                if (it!!) showProgress() else hideProgress()
                isLoading = it
            })
        }
    }

    override fun layoutId(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spanCount = if (activity?.resources?.configuration!!.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 4
        initMovieListView()
        loadMovies()
    }

    private fun initMovieListView() {
        listMovies.setHasFixedSize(true)
        gridLayoutManager = GridLayoutManager(context, spanCount)
        listMovies.layoutManager = gridLayoutManager
        val imageBaseUrl = preferenceHelper.imageBaseUrl + preferenceHelper.posterSize
        moviesListAdapter = MoviesListAdapter(context!!, imageBaseUrl)
        listMovies.adapter = moviesListAdapter
        listMovies.addItemDecoration(SpacesItemDecoration(5))
        listMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = gridLayoutManager.childCount
                val totalItemtCount = gridLayoutManager.itemCount
                val pastVisibleItems = gridLayoutManager.findFirstVisibleItemPosition()
                if (visibleItemCount + pastVisibleItems >= totalItemtCount && !isLoading) {
                    homeViewModel.getNowPlayingMovies(apiKey)
                }
            }
        })
    }

    private fun loadMovies() {
        homeViewModel.getNowPlayingMovies(apiKey)
    }

    private fun updateListMovies(newMovies: List<NowPlayingMovie>) {
        moviesListAdapter.addNewMovies(newMovies)
    }

}