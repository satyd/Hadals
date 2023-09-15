package com.levp.hadals.data

sealed class SpeciesItem(
    var height: Int
) {
    data class Species(
        val title: String,
        val scientificName: String = "",
        var depthMin: Int = 0,
        var depthMax: Int = 200,
        val description: String,
        val imageResource: Int,
        val link: String,
        var imageWidth: Int = 100,
        var imageHeight: Int = 100,
    ) : SpeciesItem(imageHeight)

    data class Spacer(var spacerHeight: Int) : SpeciesItem(spacerHeight)
}