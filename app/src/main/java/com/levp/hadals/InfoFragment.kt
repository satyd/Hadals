package com.levp.hadals

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class InfoFragment : Fragment(R.layout.species_data) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = requireArguments().getString("title")
        val name = requireArguments().getString("name")
        val description = requireArguments().getString("description")
        //val link = requireArguments().getString("link")
        view.findViewById<TextView>(R.id.title).text = title
        view.findViewById<TextView>(R.id.name).text = name
        view.findViewById<TextView>(R.id.description).text = description
        //view.findViewById<TextView>(R.id.more).text = link
    }
}