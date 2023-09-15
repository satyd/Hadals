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
            val depthMin = requireArguments().getInt(DEPTH_MIN)
            val depthMax = requireArguments().getInt(DEPTH_MAX)
            speciesData = Species(title, name, depthMin, depthMax, description, 0, link)
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
        with(speciesData) {
            view.title.text = title
            view.name.text = scientificName
            view.description.text = description
            view.depthRange.text =
                getString(R.string.info_depths_range, depthMin, depthMax)
        }
        return view.root
    }

    fun newInstance(species: Species): InfoFragmentDialog {
        val fragment = InfoFragmentDialog()
        val args = Bundle()
        args.putString(TITLE, species.title)
        args.putString(NAME, species.scientificName)
        args.putString(DESCRIPTION, species.description)
        args.putString(LINK, species.link)
        args.putInt(DEPTH_MIN, species.depthMin)
        args.putInt(DEPTH_MAX, species.depthMax)
        fragment.arguments = args
        return fragment
    }

    companion object {
        const val TITLE = "title"
        const val NAME = "scientificName"
        const val DESCRIPTION = "description"
        const val LINK = "link"
        const val DEPTH_MIN = "minDepth"
        const val DEPTH_MAX = "maxDepth"
    }
}