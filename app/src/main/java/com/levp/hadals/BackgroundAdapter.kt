package com.levp.hadals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.util.Depths

class BackgroundAdapter() :
    RecyclerView.Adapter<BackgroundAdapter.BgViewHolder>() {

    companion object {
        private const val rowCount = Depths.Bathypelagic
        private val RowList = List<Int>(rowCount) { it + 1 }
    }

    class BgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.bgTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BgViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.background_element, parent, false)

        return BgViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(bgViewHolder: BgViewHolder, position: Int) {
        val bgValue = RowList[position]
        bgViewHolder.textView.text = "$bgValue"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = RowList.size

}