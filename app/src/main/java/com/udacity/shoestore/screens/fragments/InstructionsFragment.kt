package com.udacity.shoestore.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_instructions, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container,
        false)
        binding.buttonShoeStore.setOnClickListener(
           // Navigation.createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeListFragment)
            Navigation.createNavigateOnClickListener(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
        )

        return binding.root
    }

}