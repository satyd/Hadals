package com.levp.hadals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.levp.hadals.data.SpeciesItem
import com.levp.hadals.data.SpeciesItem.Species
import com.levp.hadals.data.SpeciesItem.Spacer
import com.levp.hadals.databinding.ActivityMainBinding
import com.levp.hadals.recycler.BackgroundAdapter
import com.levp.hadals.recycler.BackgroundItemDecoration
import com.levp.hadals.recycler.SpeciesAdapter
import com.levp.hadals.util.showPopup

class MainActivity : AppCompatActivity() {

    //private val decorator by lazy {BackgroundItemDecoration()}
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        val showPopup = { view: View, int: Int ->
            this@MainActivity.showPopup(view, int)
        }

        val showInfo = { species: Species ->
            if (savedInstanceState == null) {
                openFragment(species)
            }
        }

        val backgroundRv = binding.rvBackground

        with(backgroundRv) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = BackgroundAdapter(showPopup)
            addItemDecoration(BackgroundItemDecoration())
        }
        val speciesRv = binding.rvSpecies
        with(speciesRv) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = SpeciesAdapter(showInfo, loadSpecies())
        }
    }

    private fun openFragment(species: Species) {
        val bundle = with(species) {
            bundleOf(
                "title" to title,
                "name" to scientificName,
                "description" to description,
                "link" to link,
            )
        }
        val fragment = InfoFragmentDialog().newInstance(species)
        fragment.show(supportFragmentManager, "InfoFragment")
        /* fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment, "add")
        transaction.addToBackStack(null)
        transaction.commit()*/
    }

    private fun loadSpecies(): ArrayList<SpeciesItem> {
        return arrayListOf(
            Species(
                "Portuguese man o'war",
                "Physalia physalis",
                "The Portuguese man o' war also known as the man-of-war is a marine" +
                        " hydrozoan found in the Atlantic Ocean and the Indian Ocean.\n" +
                        "The Portuguese man o' war is a conspicuous member of the neuston, " +
                        "the community of organisms that live at the ocean surface. It has numerous" +
                        " venomous microscopic nematocysts which deliver a painful sting " +
                        "powerful enough to kill fish, and has been known to occasionally kill humans." +
                        " Although it superficially resembles a jellyfish, the Portuguese man o' war" +
                        " is in fact a siphonophore. Like all siphonophores, it is a colonial organism," +
                        " made up of many smaller units called zooids. All zooids in a colony" +
                        " are genetically identical, but fulfill specialized functions such as feeding " +
                        "and reproduction, and together allow the colony to operate as a single individual.",
                R.drawable.man_o_war,
                ""
            ),
            Spacer(100*4),
            Species(
                "Fish", "-", "Most of the known fish species live in so called" +
                        "\"photic zone\", the layer of water, easily penetrable by the sunlight. ",
                R.drawable.yellow_tuna, ""
            ),
            Spacer(500*4),
            Species(
                "Giant Oarfish",
                "Regalecus glesne",
                "These giant fish dwell in the twilight zone and are rarely seen on the surface.",
                R.drawable.oarfish,
                "https://youtu.be/9FqwhW0B3tY?si=E3D2Etef_Vn54TPF&t=1120"
            ),
            Spacer(1000*4),
            Species(
                "Vampire Squid",
                "Vampyroteuthis infernalis",
                "Is a small cephalopod found throughout temperate and tropical oceans " +
                        "in extreme deep sea conditions. The vampire squid uses its bioluminescent " +
                        "organs and its unique oxygen metabolism to thrive in the parts of the ocean " +
                        "with the lowest concentrations of oxygen. It has two long retractile filaments, " +
                        "located between the first two pairs of arms on its dorsal side, which " +
                        "distinguish it from both octopuses and squids, and places it in its own order," +
                        " Vampyromorphida, although its closest relatives are octopods. As a phylogenetic relict, " +
                        "it is the only known surviving member of its order.",
                R.drawable.vampire_squid,
                ""
            ),
            Spacer(1000*4),
            Species(
                "Chimaera",
                "Order:\tChimaeriformes",
                "Are cartilaginous fish in the order Chimaeriformes /kɪˈmɛrɪfɔːrmiːz/, " +
                        "known informally as ghost sharks, rat fish, spookfish, or rabbit fish; " +
                        "the last three names are not to be confused with rattails, Opisthoproctidae," +
                        " or Siganidae, respectively.",
                R.drawable.chimaera,
                ""
            ),
        )
    }
}