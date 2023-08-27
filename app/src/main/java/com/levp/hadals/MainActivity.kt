package com.levp.hadals

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.data.SpeciesItem
import com.levp.hadals.data.SpeciesItem.Spacer
import com.levp.hadals.data.SpeciesItem.Species
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
                openDialogInfo(species)
            }
        }


        val backgroundRv = binding.rvBackground
        val speciesRv = binding.rvSpecies

        val scrollListeners = arrayOfNulls<RecyclerView.OnScrollListener>(2)
        scrollListeners[0] = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                backgroundRv.removeOnScrollListener(scrollListeners[1]!!)
                backgroundRv.scrollBy(dx, dy)
                backgroundRv.addOnScrollListener(scrollListeners[1]!!)
            }
        }
        scrollListeners[1] = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                speciesRv.removeOnScrollListener(scrollListeners[0]!!)
                speciesRv.scrollBy(dx, dy)
                speciesRv.addOnScrollListener(scrollListeners[0]!!)
            }
        }
        speciesRv.addOnScrollListener(scrollListeners[0]!!)
        backgroundRv.addOnScrollListener(scrollListeners[1]!!)
        speciesRv.recycledViewPool.setMaxRecycledViews(0, 0)

        with(backgroundRv) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = BackgroundAdapter(showPopup)
            addItemDecoration(BackgroundItemDecoration())
        }

        with(speciesRv) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = SpeciesAdapter(showInfo, loadSpecies())
        }
    }

    private fun openDialogInfo(species: Species) {
        val fragment = InfoFragmentDialog().newInstance(species)
        fragment.show(supportFragmentManager, "InfoFragment")
    }

    private fun loadSpecies(): ArrayList<SpeciesItem> {
        return arrayListOf(
            Species(
                "Portuguese man o'war",
                "Physalia physalis",
                0 to 5,
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
                "",
                50,
                101
            ),
            Spacer(100),
            Species(
                "Fish",
                "-",
                0 to 200,
                "Most of the known fish species live in so called" +
                        "\"photic zone\", the layer of water, easily penetrable by the sunlight. ",
                imageResource = R.drawable.fishes,
                link = "",
                imageWidth = 100,
                imageHeight = 85
            ),
            Spacer(300),
            Species(
                "Giant Oarfish",
                "Regalecus glesne",
                0 to 1000,
                "These giant fish dwell in the twilight zone and are rarely seen on the surface.",
                R.drawable.oarfish,
                "https://youtu.be/9FqwhW0B3tY?si=E3D2Etef_Vn54TPF&t=1120",
                imageWidth = 100,
                imageHeight = 69
            ),
            Spacer(400),
            Species(
                "Vampire Squid",
                "Vampyroteuthis infernalis",
                600 to 1200,
                "Is a small cephalopod found throughout temperate and tropical oceans " +
                        "in extreme deep sea conditions. The vampire squid uses its bioluminescent " +
                        "organs and its unique oxygen metabolism to thrive in the parts of the ocean " +
                        "with the lowest concentrations of oxygen. It has two long retractile filaments, " +
                        "located between the first two pairs of arms on its dorsal side, which " +
                        "distinguish it from both octopuses and squids, and places it in its own order," +
                        " Vampyromorphida, although its closest relatives are octopods. As a phylogenetic relict, " +
                        "it is the only known surviving member of its order.",
                R.drawable.vampire_squid,
                "",
                100,
                64
            ),
            Spacer(200),
            Species(
                "Sperm Whale",
                "Physeter macrocephalus",
                0 to 2250,
                "This whale is the largest of the toothed whales and the largest toothed predator." +
                        " It is the only living member of the genus Physeter and one of three extant species " +
                        "in the sperm whale family, along with the pygmy sperm whale and dwarf sperm whale" +
                        " of the genus Kogia.",
                R.drawable.cachalot,
                "xdd",
                191,
                50
            ),
            Spacer(300),
            Species(
                "Barreleye",
                "Family:\tOpisthoproctidae",
                400 to 2500,
                "are small deep-sea argentiniform fish comprising the family Opisthoproctidae" +
                        " found in tropical-to-temperate waters of the Atlantic, Pacific, and Indian Oceans",
                R.drawable.barreleye,
                "xdd",
                100,
                39
            ),
            Spacer(800),
            Species(
                "Chimaera",
                "Order:\tChimaeriformes",
                200 to 2600,
                "Are cartilaginous fish in the order Chimaeriformes /kɪˈmɛrɪfɔːrmiːz/, " +
                        "known informally as ghost sharks, rat fish, spookfish, or rabbit fish; " +
                        "the last three names are not to be confused with rattails, Opisthoproctidae," +
                        " or Siganidae, respectively.",
                R.drawable.chimaera,
                "",
                100,
                46
            ),
        )
    }
}