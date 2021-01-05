package com.gbizotto.wifimonitor.feature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gbizotto.wifimonitor.R
import com.gbizotto.wifimonitor.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        viewModel.onStart()
        observeViewModel()

        binding.btnRefresh.setOnClickListener {
            viewModel.refresh()
        }
    }

    private fun observeViewModel() {
        viewModel.logs.observe(this, {
            val adapter = ConnectionLogAdapter(it, this@MainActivity)
            binding.list.apply{
                layoutManager = LinearLayoutManager( this@MainActivity)
                this.adapter = adapter
            }
        })
    }
}