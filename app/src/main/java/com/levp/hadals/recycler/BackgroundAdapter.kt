package com.levp.hadals.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.R
import com.levp.hadals.util.Depths

class BackgroundAdapter(
    private val onClick: (View, Int) -> Unit
) :
    RecyclerView.Adapter<BaseViewHolder.BgViewHolder>() {

    companion object {
        private const val rowCount = Depths.Bathypelagic
        private val RowList = List(rowCount) { it + 1 }
        private val borderThresholds =
            listOf(Depths.Epipelagic, Depths.Mesopelagic, Depths.Bathypelagic, Depths.Abyssopelagic)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder.BgViewHolder {
        val bgView = LayoutInflater.from(parent.context)
            .inflate(R.layout.background_element, parent, false)
        return BaseViewHolder.BgViewHolder(bgView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder.BgViewHolder, position: Int) {
        holder.itemView.setOnClickListener { onClick(holder.itemView, position) }
    }


    override fun getItemCount() = RowList.size

}