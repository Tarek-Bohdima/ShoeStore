package com.udacity.shoestore.screens.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeStoreViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList



    fun addShoe(shoe: Shoe) {
       _shoesList.value?.add(shoe)
        Timber.i("addShoe() called with: shoe = $shoe")
    }
}