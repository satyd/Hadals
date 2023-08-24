package com.levp.hadals.data

data class Species(
    val name: String,
    val scientificName: String = "",
    val description: String,
    val imageResource: Int,
    val link: String
)
