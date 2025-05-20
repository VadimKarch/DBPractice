package com.vadimkarch.dbpractice.task3.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vadimkarch.dbpractice.databinding.ActivityTask3Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class Task3Activity : AppCompatActivity() {

    private val binding: ActivityTask3Binding by lazy {
        ActivityTask3Binding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<Task3ViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.task3) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.getRandomHttpCodeBtn.setOnClickListener {
            viewModel.getRandomHttpCode()
        }
    }
}