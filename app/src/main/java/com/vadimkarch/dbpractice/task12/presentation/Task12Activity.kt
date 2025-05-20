package com.vadimkarch.dbpractice.task12.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.vadimkarch.dbpractice.databinding.ActivityTask12Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class Task12Activity : AppCompatActivity() {

    private val binding: ActivityTask12Binding by lazy {
        ActivityTask12Binding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<Task12ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.task12) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.availableBouquetsInfo.collect { bouquetsInfo ->
                    bouquetsInfo.forEach {
                        Log.d("Tag111", it.toString())
                    }
                }
            }
        }

        binding.buyBouquetsBtn.setOnClickListener {
            lifecycleScope.launch {
                viewModel.buyBouquet(1)
                delay(1000)

                viewModel.buyBouquet(2)
                delay(1000)

                viewModel.buyBouquet(3)
            }
        }
    }
}