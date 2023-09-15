package com.levp.hadals.data

import com.levp.hadals.R

fun loadSpecies(): ArrayList<SpeciesItem> {
    return arrayListOf(
        SpeciesItem.Species(
            "Portuguese man o'war",
            "Physalia physalis",
            0,
            5,
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
        SpeciesItem.Spacer(100),
        SpeciesItem.Species(
            "Fish",
            "-",
            0,
            200,
            "Most of the known fish species live in so called" +
                    "\"photic zone\", the layer of water, easily penetrable by the sunlight. ",
            imageResource = R.drawable.fishes,
            link = "",
            imageWidth = 100,
            imageHeight = 85
        ),
        SpeciesItem.Spacer(300),
        SpeciesItem.Species(
            "Giant Oarfish",
            "Regalecus glesne",
            0,
            1000,
            "These giant fish dwell in the twilight zone and are rarely seen on the surface.",
            R.drawable.oarfish,
            "https://youtu.be/9FqwhW0B3tY?si=E3D2Etef_Vn54TPF&t=1120",
            imageWidth = 100,
            imageHeight = 69
        ),
        SpeciesItem.Spacer(400),
        SpeciesItem.Species(
            "Vampire Squid",
            "Vampyroteuthis infernalis",
            600,
            1200,
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
        SpeciesItem.Spacer(200),
        SpeciesItem.Species(
            "Sperm Whale",
            "Physeter macrocephalus",
            0,
            2250,
            "This whale is the largest of the toothed whales and the largest toothed predator." +
                    " It is the only living member of the genus Physeter and one of three extant species " +
                    "in the sperm whale family, along with the pygmy sperm whale and dwarf sperm whale" +
                    " of the genus Kogia.",
            R.drawable.cachalot,
            "xdd",
            280,
            42
        ),
        SpeciesItem.Spacer(300),
        SpeciesItem.Species(
            "Barreleye",
            "Family:\tOpisthoproctidae",
            400,
            2500,
            "are small deep-sea argentiniform fish comprising the family Opisthoproctidae" +
                    " found in tropical-to-temperate waters of the Atlantic, Pacific, and Indian Oceans",
            R.drawable.barreleye,
            "xdd",
            100,
            39
        ),
        SpeciesItem.Spacer(800),
        SpeciesItem.Species(
            "Chimaera",
            "Order:\tChimaeriformes",
            200,
            2600,
            "Are cartilaginous fish in the order Chimaeriformes /kɪˈmɛrɪfɔːrmiːz/, " +
                    "known informally as ghost sharks, rat fish, spookfish, or rabbit fish; " +
                    "the last three names are not to be confused with rattails, Opisthoproctidae," +
                    " or Siganidae, respectively.",
            R.drawable.chimaera,
            "",
            100,
            46
        ),
        SpeciesItem.Spacer(1500),
        SpeciesItem.Species(
            "Grenadier or Rattail",
            "Subfamily:\tMacrourinae",
            200,
            7000,
            "One of the most abundant deep sea fish",
            R.drawable.rattail,
            "",
            110,
            62
        ),
        SpeciesItem.Spacer(2000),
        SpeciesItem.Species(
            "Snail fish",
            "Family:\tLiparidae",
            1000,
            8500,
            "Widely distributed from the Arctic to Antarctic Oceans, the snailfish family " +
                    "contains more than 30 genera and about 410 described species, but there are also" +
                    " many undescribed species. Snailfish species can be found in depths ranging from" +
                    " shallow coastal waters to more than 8,300 m (27,200 ft), " +
                    "and species of the Liparid family have been found in seven ocean trenches.",
            R.drawable.snailfish,
            "",
            100,
            67
        ),
        SpeciesItem.Spacer(2000),
        SpeciesItem.Species(
            "Giant amphipod",
            "Hirondellea gigas",
            8000,
            11000,
            "The largest creatures that inhabit the deepest points of the world ocean",
            R.drawable.giant_amphipod,
            "",
            100,
            54
        ),
    )
}