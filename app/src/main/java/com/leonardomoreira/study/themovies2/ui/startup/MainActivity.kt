package com.leonardomoreira.study.themovies2.ui.startup

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.leonardomoreira.study.themovies2.presentation.movie.contract.StartupContract
import com.leonardomoreira.study.themovies2.presentation.movie.presenter.MovieListAdapter
import com.leonardomoreira.study.themovies2.presentation.movie.presenter.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), StartupContract.View {

    private val presenter: StartupContract.Presenter by inject()

    private val adapter = MovieListAdapter()

    private lateinit var gridLayoutManager:GridLayoutManager

    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.verizonconnect.fsdapp.R.layout.activity_main)
        initList()
        presenter.attachView(this)
        presenter.loadMovies()
    }

    private fun initList() {
        val recyclerView = findViewById<RecyclerView>(com.verizonconnect.fsdapp.R.id.movies_list_view)
        val numberOfColumns = 3
        gridLayoutManager =  GridLayoutManager(this, numberOfColumns)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(recycleViewScrollListener)

        adapter.callback = {
            presenter.showMovieDetails(it)
        }
    }

    private val recycleViewScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, scrollX: Int, scrollY: Int) {
            super.onScrolled(recyclerView, scrollX, scrollY)
            val visibleItemCount = gridLayoutManager.childCount
            val totalItemCount = gridLayoutManager.itemCount
            val firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition()

            if(!isLoading && !isLastPage) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= PAGE_SIZE
                ) {
                    showNextPage()
                }
            }
        }
    }

    override fun showLoader() {
        progress_circular.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progress_circular.visibility = View.GONE
    }

    override fun showMovies(list: List<MovieViewModel>) {
        adapter.addMovies(list)
        adapter.notifyDataSetChanged()
    }

    override fun showNextPage() {
        isLoading = true
        presenter.loadNextPage()
    }

    companion object {
        const val PAGE_SIZE: Int = 12
    }

}
