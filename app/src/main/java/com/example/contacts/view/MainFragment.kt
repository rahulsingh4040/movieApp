package com.example.contacts.view

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contacts.R
import com.example.contacts.adapter.MovieListAdapter
import com.example.contacts.data.MovieEntity
import com.example.contacts.databinding.MainFragmentBinding

class MainFragment : Fragment(),
    MovieListAdapter.ListItemListener {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding

    private lateinit var adapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        with(binding.recyclerView) {
            setHasFixedSize(true)
            val divider = DividerItemDecoration(
                context, LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        viewModel.contactsList?.observe(viewLifecycleOwner) {
            adapter = MovieListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        }

        addSampleDataFromDatabase()

        return binding.root
    }

    override fun onItemClick(movie: MovieEntity) {
        val action = MainFragmentDirections.actionMainFragmentToDetailedFragment(movie.title, movie.rating, movie.overview, movie.popularity, movie.releaseDate)
        findNavController().navigate(action)
    }

    override fun onItemsSelectionChanged() {
        requireActivity().invalidateOptionsMenu()
    }

    private fun addSampleDataFromDatabase() {
        viewModel.addSampleData()
    }

}