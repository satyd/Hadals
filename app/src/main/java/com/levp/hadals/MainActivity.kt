package com.levp.hadals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.levp.hadals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private val decorator by lazy {BackgroundItemDecoration()}
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        val recyclerView = binding.rvMain
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = BackgroundAdapter()
            addItemDecoration(BackgroundItemDecoration())
        }
    }
}