package com.vadimkarch.dbpractice.task12.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vadimkarch.dbpractice.task12.data.model.BouquetInfo
import com.vadimkarch.dbpractice.task12.domain.useCase.BuyBouquetUseCase
import com.vadimkarch.dbpractice.task12.domain.useCase.GetAvailableBouquetsInfoUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class Task12ViewModel(
    getAvailableBouquetsInfoUseCase: GetAvailableBouquetsInfoUseCase,
    private val buyBouquetUseCase: BuyBouquetUseCase
) : ViewModel() {

    val availableBouquetsInfo: StateFlow<List<BouquetInfo>> =
        getAvailableBouquetsInfoUseCase.invoke()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())

    fun buyBouquet(bouquetId: Long) {
        viewModelScope.launch {
            Log.d("Tag111", "----------\nBuying bouquet id = $bouquetId")
            if (buyBouquetUseCase.invoke(bouquetId)) {
                Log.d("Tag111", "Bought bouquet id = $bouquetId\n----------")
            } else {
                Log.d("Tag111", "Unavailable bouquet id = $bouquetId\n----------")
            }
        }
    }
}