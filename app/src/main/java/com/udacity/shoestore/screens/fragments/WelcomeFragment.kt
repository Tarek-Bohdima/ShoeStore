package com.udacity.shoestore.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.fragment_welcome, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.buttonInstructions.setOnClickListener(
            // Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionsFragment)
            Navigation.createNavigateOnClickListener(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        )

        return binding.root
    }
}