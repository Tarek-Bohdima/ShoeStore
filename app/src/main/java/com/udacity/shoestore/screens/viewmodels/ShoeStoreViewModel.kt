package com.udacity.shoestore.screens.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel : ViewModel() {


    private val shoes = mutableListOf<Shoe>()


    private val _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    fun addShoe(newShoe: Shoe) {

        shoes.add(newShoe)
        _shoesList.value = shoes
        Timber.i("addShoe() called with: shoe = $newShoe")

    }
}