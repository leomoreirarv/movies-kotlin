package com.leonardomoreira.study.themovies2.ui.movies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.leonardomoreira.study.themovies2.presentation.movie.presenter.MovieViewModel
import com.squareup.picasso.Picasso
import com.verizonconnect.fsdapp.R

class MovieListAdapter: RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var listMovies: List<MovieViewModel> = emptyList()

    var callback:((MovieViewModel) -> Unit) ? = null

    fun addMovies(listMovies: List<MovieViewModel>){
        this.listMovies = listMovies
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myInflater = LayoutInflater.from(parent.context)
        val view = myInflater.inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMovies[position])
        holder.itemView.setOnClickListener {
            callback?.invoke(listMovies[holder.adapterPosition])
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieViewModel){
            val poster = itemView.findViewById<ImageView>(R.id.movie_poster)
            val title = itemView.findViewById<TextView>(R.id.title)

            val imageSize = itemView.context.getString(R.string.poster_small_size)
            val baseUrlImage = itemView.context.getString(R.string.base_image_url)

            val posterImage = movie.getImageFullUrl(imageSize, baseUrlImage)

            title.text = movie.title
            Picasso.with(itemView.context).load(posterImage).into(poster)
        }
    }
}