package com.udacity.shoestore.screens.fragments

import android.os.Bundle
import android.view.*
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
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val shoeViewModel: ShoeStoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        //more concise way to inflate
        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        binding.emptyView.visibility = View.VISIBLE

        binding.fab.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        )

        shoeViewModel.shoesList.observe(viewLifecycleOwner, {
            Timber.d("observer called from ShoeListFragment")
            it.forEach {

                binding.emptyView.visibility = View.GONE
                val shoeListItem =
                    ItemShoeListBinding.inflate(LayoutInflater.from(requireContext()), null, false)
                shoeListItem.apply {
                    this.shoeName.text = getString(R.string.shoe_name, it.name)
                    this.company.text = getString(R.string.company, it.company)
                    this.shoeSize.text = getString(R.string.size, it.size)
                    this.description.text = getString(R.string.description, it.description)
                    this.images.text = getString(R.string.images, "some clickable urls")
                }
                binding.linearlayoutShoelist.addView(shoeListItem.root)
            }
        })

        return binding.root
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