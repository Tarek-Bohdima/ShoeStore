package com.udacity.shoestore.screens.fragments

import android.opengl.Visibility
import android.os.Bundle
import android.view.*
import android.view.View.GONE
import androidx.constraintlayout.widget.ConstraintSet.GONE
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeListBinding
import com.udacity.shoestore.screens.viewmodels.ShoeStoreViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val shoeViewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)

        binding.emptyView.visibility = View.VISIBLE

        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        )


        displayShoes(inflater, container)

        return binding.root
    }

    private fun displayShoes(inflater: LayoutInflater, container: ViewGroup?) {

        shoeViewModel.shoesList.observe(viewLifecycleOwner, {
            it.forEach {

                binding.emptyView.visibility = View.GONE
                val shoeListItem =
                    ItemShoeListBinding.inflate(LayoutInflater.from(requireContext()), null, false)
                shoeListItem.apply {
                    this.shoeName.text = getString(R.string.shoe_name, "Nike Air")
                    this.company.text = getString(R.string.company, "Nike")
                    this.shoeSize.text = getString(R.string.size, 42.0)
                    this.description.text = getString(R.string.description, "Description about the shoe")
                    this.images.text = getString(R.string.images, "some urls")
                }
                    binding.linearlayoutShoelist.addView(shoeListItem.root)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    // Returns true if NavigationUI.onNavDestinationSelected return true, else
    // return super.onOptionsItemSelected.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }
}