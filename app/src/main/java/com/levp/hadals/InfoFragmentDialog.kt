package com.levp.hadals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.levp.hadals.data.SpeciesItem.Species
import com.levp.hadals.databinding.SpeciesDataBinding


class InfoFragmentDialog : DialogFragment() {
    private lateinit var speciesData: Species

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            val title = requireArguments().getString(TITLE)!!
            val name = requireArguments().getString(NAME)!!
            val description = requireArguments().getString(DESCRIPTION)!!
            val link = requireArguments().getString(LINK)!!
            speciesData = Species(title, name, description, 0, link)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        val view =
            SpeciesDataBinding.inflate(inflater)
        view.title.text = speciesData.title
        view.name.text = speciesData.scientificName
        view.description.text = speciesData.description
        return view.root
    }

    fun newInstance(species: Species): InfoFragmentDialog {
        val fragment = InfoFragmentDialog()
        val args = Bundle()
        args.putString(TITLE, species.title)
        args.putString(NAME, species.scientificName)
        args.putString(DESCRIPTION, species.description)
        args.putString(LINK, species.link)
        fragment.arguments = args
        return fragment
    }

    companion object {
        const val TITLE = "title"
        const val NAME = "scientificName"
        const val DESCRIPTION = "description"
        const val LINK = "link"
    }
}