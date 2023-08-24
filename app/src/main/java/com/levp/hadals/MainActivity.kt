package com.levp.hadals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.levp.hadals.data.Species
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
            adapter = SpeciesAdapter(showPopup, loadSpecies())
        }
    }

    fun loadSpecies(): ArrayList<Species> {
        return arrayListOf(
            Species("Portuguese man'o'war", "kekius 2", "Dis creature", R.drawable.man_o_war, ""),
            Species("Fish", "kekius 2", "Dis creature", R.drawable.yellow_tuna, ""),
            Species("Giant Oarfish", "kek1", "King of Herrings", R.drawable.oarfish, ""),
            Species("Vampire Squid", "kekius 2", "Dis creature", R.drawable.vampire_squid, ""),
            Species("Chimaera", "kekius", "Dis creature", R.drawable.chimaera, ""),

        )
    }
}