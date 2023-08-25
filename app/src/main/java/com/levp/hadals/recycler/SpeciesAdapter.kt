package com.levp.hadals.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.R
import com.levp.hadals.data.SpeciesItem
import com.levp.hadals.util.Depths

class SpeciesAdapter(
    private val onClick: (SpeciesItem.Species) -> Unit,
    private val speciesList: ArrayList<SpeciesItem>
) :
    RecyclerView.Adapter<BaseViewHolder.SpeciesViewHolder>() {

    companion object {
        private const val rowCount = Depths.Bathypelagic

        private val borderThresholds =
            listOf(Depths.Epipelagic, Depths.Mesopelagic, Depths.Bathypelagic, Depths.Abyssopelagic)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder.SpeciesViewHolder {

        val speciesView = LayoutInflater.from(parent.context)
            .inflate(R.layout.species_button, parent, false)
        return BaseViewHolder.SpeciesViewHolder(speciesView)

    }

    override fun onBindViewHolder(holder: BaseViewHolder.SpeciesViewHolder, position: Int) {
        val newItem = speciesList[position]
        when (newItem) {
            is SpeciesItem.Spacer -> {
                holder.itemView.layoutParams = ViewGroup.LayoutParams(0, newItem.height)
            }

            is SpeciesItem.Species -> {
                holder.bind(newItem.imageResource)
                holder.itemView.setOnClickListener { onClick(newItem) }
            }
        }

    }


    override fun getItemCount() = speciesList.size

}