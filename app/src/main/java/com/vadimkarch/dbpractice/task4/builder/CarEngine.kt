package com.vadimkarch.dbpractice.task4.builder

data class CarEngine(
    val volume: Float,
    val horsePower: Int,
    val fuelType: FuelType
) {

    enum class FuelType {
        PETROL, DIESEL, ELECTRIC
    }
}

