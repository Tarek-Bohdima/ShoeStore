package com.udacity.shoestore.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_details, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.buttonCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(DetailsFragmentDirections.actionDetailFragmentToShoeListFragment())
        )

        binding.buttonSave.setOnClickListener(
            Navigation.createNavigateOnClickListener(DetailsFragmentDirections.actionDetailFragmentToShoeListFragment())
        )

        return binding.root
    }

}