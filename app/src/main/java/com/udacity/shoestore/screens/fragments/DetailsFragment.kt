package com.udacity.shoestore.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.viewmodels.ShoeStoreViewModel
import timber.log.Timber

class DetailsFragment : Fragment() {

    private val shoeViewModel: ShoeStoreViewModel by activityViewModels()

    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        //more concise way to inflate
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            shoe = Shoe()

            buttonCancel.setOnClickListener {
                it.findNavController()
                    .navigate(DetailsFragmentDirections.actionDetailFragmentToShoeListFragment())
            }

            buttonSave.setOnClickListener {

                binding.shoe?.run {
                    val shoeToAdd = Shoe(
                        name,
                        size,
                        company,
                        description,
                        images
                    )

                    saveShoe(shoeToAdd)
                }

                it.findNavController()
                    .navigate(DetailsFragmentDirections.actionDetailFragmentToShoeListFragment())
            }
        }
    }

    private fun saveShoe(newShoe: Shoe) {
        Timber.d("saveShoe is called with $newShoe")
        shoeViewModel.addShoe(newShoe)
    }

}