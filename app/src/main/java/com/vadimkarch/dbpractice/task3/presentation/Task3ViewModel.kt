package com.vadimkarch.dbpractice.task3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vadimkarch.dbpractice.task3.domain.useCase.GetRandomHttpCodeUseCase
import kotlinx.coroutines.launch

class Task3ViewModel(private val getRandomHttpCodeUseCase: GetRandomHttpCodeUseCase) : ViewModel() {

    fun getRandomHttpCode() {
        viewModelScope.launch {
            getRandomHttpCodeUseCase.invoke()
        }
    }
}