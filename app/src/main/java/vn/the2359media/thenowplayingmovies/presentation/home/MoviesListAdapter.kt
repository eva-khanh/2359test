package vn.the2359media.thenowplayingmovies.presentation.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.core.GlideApp
import vn.the2359media.thenowplayingmovies.core.ext.inflate
import vn.the2359media.thenowplayingmovies.data.model.NowPlayingMovie
import java.util.*

class MoviesListAdapter(private val context: Context, private val imageBaseUrl: String) :
    RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {
    private val listMovies = LinkedList<NowPlayingMovie>()

    internal fun addNewMovies(newMovies: List<NowPlayingMovie>) {
        if (newMovies.isNotEmpty()) {
            for (movie in newMovies) {
                if (!listMovies.contains(movie)) {
                    listMovies.add(movie)
                }
            }
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = parent.inflate(R.layout.item_movie)
        return MovieViewHolder(itemView, imageBaseUrl, context)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    class MovieViewHolder(itemView: View, private val imageBaseUrl: String, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        private val posterImageView: ImageView = itemView.findViewById(R.id.imagePoster)
        private val voteAverageTextView: TextView = itemView.findViewById(R.id.textVoteAverage)

        fun bind(movie: NowPlayingMovie) {
            val moviePosterUrl = imageBaseUrl + movie.posterPath
            GlideApp.with(context)
                .load(moviePosterUrl)
                .into(posterImageView)
            voteAverageTextView.text = movie.voteAverage.toString()
        }
    }
}