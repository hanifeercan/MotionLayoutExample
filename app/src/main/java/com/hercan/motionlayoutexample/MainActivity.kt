package com.hercan.motionlayoutexample

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.hercan.motionlayoutexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private val adapter = CartoonListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindUi()
        viewModel.getAllBooks()
        observeViewModel()
    }

    private fun observeViewModel() = with(binding) {
        viewModel.cartoonsScreenUiState.observe(this@MainActivity) {
            when {
                it.isError -> {
                    progressBar.visibility = View.GONE
                    rvCartoon.visibility = View.GONE
                    ivInfo.visibility = View.VISIBLE
                }

                it.isLoading -> {
                    progressBar.visibility = View.VISIBLE
                    rvCartoon.visibility = View.GONE
                    ivInfo.visibility = View.GONE
                }

                else -> {
                    if (it.cartoons.isNotEmpty()) {
                        adapter.submitList(it.cartoons) {
                            progressBar.visibility = View.GONE
                            rvCartoon.visibility = View.VISIBLE
                            ivInfo.visibility = View.GONE
                        }
                    } else {
                        progressBar.visibility = View.GONE
                        rvCartoon.visibility = View.GONE
                        ivInfo.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun bindUi() = with(binding) {
        rvCartoon.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        rvCartoon.setHasFixedSize(true)
        rvCartoon.adapter = adapter
    }
}