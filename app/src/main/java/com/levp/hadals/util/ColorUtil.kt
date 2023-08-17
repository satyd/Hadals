package com.levp.hadals.util

import android.graphics.Color
import android.provider.SyncStateContract.Constants
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.graphics.toColor
import com.levp.hadals.R
import java.lang.Exception

fun getColorByGroup(position: Int): Color {
    return when (position) {
        in 0..Depths.Epipelagic -> {
            getEpipelagicColor(position)
        }

        in Depths.Epipelagic + 1..Depths.Mesopelagic -> {
            getMesopelagicColor(position - Depths.Epipelagic)
        }

        in Depths.Mesopelagic + 1..Depths.Bathypelagic -> {
            getBathypelagicColor(position - Depths.Mesopelagic)
        }

        else -> {
            Color.WHITE.toColor()
        }
    }
}

fun getEpipelagicColor(position: Int): Color {
    return colorGradientPosition(position, Depths.Epipelagic, "#FF5fc7f8", "#FF72c4f5")
}

fun getMesopelagicColor(position: Int): Color {
    return colorGradientPosition(position, Depths.Mesopelagic, "#FF6dbfef", "#FF6b9cba")
}

fun getBathypelagicColor(position: Int): Color {
    return colorGradientPosition(position, Depths.Bathypelagic, "#FF4c84a5", "#FF2c3941")
}

fun colorGradientPosition(pos: Int, div: Int, color1: String, color2: String): Color {
    return try {
        val startColor = Color.parseColor(color1)
        val endColor = Color.parseColor(color2)
        val sBlue = startColor.blue
        val sRed = startColor.red
        val sGreen = startColor.green
        val blueDiff = (endColor.blue - sBlue) * pos / div + sBlue
        val redDiff = (endColor.red - sRed) * pos / div + sRed
        val greenDiff = (endColor.green - sGreen) * pos / div + sGreen
        val result = Color.rgb(redDiff, greenDiff, blueDiff)
        result.toColor()
    } catch (e: IllegalArgumentException) {
        Log.d("hehe", "$e no color $color1")
        Color.RED.toColor()
    }
}