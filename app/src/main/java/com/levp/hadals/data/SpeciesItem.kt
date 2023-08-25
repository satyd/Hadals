package com.levp.hadals.data

sealed class SpeciesItem(
    var height: Int
) {
    data class Species(
        val title: String,
        val scientificName: String = "",
        val description: String,
        val imageResource: Int,
        val link: String,
        var imageHeight: Int = 100
    ) : SpeciesItem(imageHeight)

    data class Spacer(var spacerHeight: Int) : SpeciesItem(spacerHeight)
}