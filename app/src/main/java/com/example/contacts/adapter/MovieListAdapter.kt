package com.example.contacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.data.MovieEntity
import com.example.contacts.databinding.ListItemBinding

class MovieListAdapter(
    private val moviesList: List<MovieEntity>,
    private val listener: ListItemListener
) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    val selectedContacts = arrayListOf<MovieEntity>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflator = LayoutInflater.from(parent.context!!)
        val view = inflator.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = moviesList[position]
        with(holder.binding) {
            movieTitle.text = movie.title
            movieDetails.text = movie.overview
            root.setOnClickListener{
                listener.onItemClick(movie)
            }
        }

    }

    override fun getItemCount() = moviesList.size

    interface ListItemListener {
        fun onItemClick(movie: MovieEntity)
        fun onItemsSelectionChanged()
    }

}