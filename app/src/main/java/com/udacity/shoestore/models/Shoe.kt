package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(var name: String = "Nike Air", var size: Double = 42.0, var company: String = "Nike", var description: String = "Some Long Description about the Shoe",
                val images: List<String> = mutableListOf()) : Parcelable
// Added default values so the app can be tested , but after that it i should verify fields are all filled with correct type values so user will be able to save