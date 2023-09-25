package com.accidentaldeveloper.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.accidentaldeveloper.hilt.adapter.TvShowAdapter
import com.accidentaldeveloper.hilt.databinding.ActivityMainBinding
import com.accidentaldeveloper.hilt.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewmodel:TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SettingUpRecyclerView()

    }

    private fun SettingUpRecyclerView() {
       tvShowAdapter = TvShowAdapter()
        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }


        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )

            setHasFixedSize(true)
        }

        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.HORIZONTAL,
                false
            )

            setHasFixedSize(true)
        }

        viewmodel.responseTvShow.observe(this,{
            tvShowAdapter.tvShows = it
        })

    }
}