package com.example.contacts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.contacts.databinding.DetailedFragmentBinding

class DetailedFragment : Fragment() {

    private lateinit var viewModel: DetailedViewModel

    private lateinit var binding: DetailedFragmentBinding

    private val args: DetailedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailedFragmentBinding.inflate(inflater, container, false)

        with(binding) {
            releaseDate.text = args.releaseDate
            ratings.text = args.ratings
            popularity.text = args.popularity
            overview.text = args.overview
        }

        (activity as AppCompatActivity).supportActionBar?.let {
            it.setHomeButtonEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setHomeAsUpIndicator(android.R.drawable.ic_menu_revert)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> returnBack()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun returnBack(): Boolean {
        findNavController().navigateUp()
        return true
    }

}