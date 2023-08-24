package com.levp.hadals.recycler

import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.R

sealed class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class BgViewHolder(itemView: View) : BaseViewHolder(itemView) {
        //val textView = itemView.findViewById<TextView>(R.id.bgTv)
    }

    class SpeciesViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val image = itemView.findViewById<ImageButton>(R.id.species_btn)

        fun bind(resource: Int) {
            image.setImageResource(resource)
        }
    }
}
