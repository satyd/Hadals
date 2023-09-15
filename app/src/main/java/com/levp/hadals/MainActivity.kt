package com.levp.hadals

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.levp.hadals.data.SpeciesItem.Species
import com.levp.hadals.data.loadSpecies
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

}