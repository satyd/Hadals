package com.levp.hadals.data

sealed class SpeciesItem(
    var height: Int
) {
    data class Species(
        val title: String,
        val scientificName: String = "",
        var depthRange: Pair<Int, Int> = 0 to 200,
        val description: String,
        val imageResource: Int,
        val link: String,
        var imageWidth: Int = 100,
        var imageHeight: Int = 100,
    ) : SpeciesItem(imageHeight)

    data class Spacer(var spacerHeight: Int) : SpeciesItem(spacerHeight)
}