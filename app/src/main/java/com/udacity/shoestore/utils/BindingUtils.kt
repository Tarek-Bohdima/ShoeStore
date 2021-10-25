@file:JvmName("BindingUtils")

package com.udacity.shoestore.utils

import androidx.databinding.InverseMethod


@InverseMethod("stringToDouble")
fun doubleToString(
    value: Double,
): String {
    return value.toString()
}

fun stringToDouble(
    value: String
): Double {
    return value.toDouble()
}
