package com.levp.hadals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.util.Depths

class BackgroundAdapter(private val onClick: (View, Int) -> Unit) :
    RecyclerView.Adapter<BackgroundAdapter.BgViewHolder>() {

    companion object {
        private const val rowCount = Depths.Bathypelagic
        private val RowList = List(rowCount) { it + 1 }
        private val borderThresholds =
            listOf(Depths.Epipelagic, Depths.Mesopelagic, Depths.Bathypelagic, Depths.Abyssopelagic)
    }

    class BgViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        //val textView = itemView.findViewById<TextView>(R.id.bgTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BgViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.background_element, parent, false)

        return BgViewHolder(view)
    }

    override fun onBindViewHolder(bgViewHolder: BgViewHolder, position: Int) {
        //val index = RowList[position]
        bgViewHolder.itemView.setOnClickListener { onClick(bgViewHolder.itemView, position) }
    }


    override fun getItemCount() = RowList.size

}