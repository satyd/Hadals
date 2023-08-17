package com.levp.hadals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.levp.hadals.databinding.ActivityMainBinding
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

        val recyclerView = binding.rvMain
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = BackgroundAdapter(showPopup)
            addItemDecoration(BackgroundItemDecoration())
        }
    }
}