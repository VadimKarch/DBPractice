package com.vadimkarch.dbpractice.task4.builder

data class CarWheel(
    val size: String,
    val type: WheelType
) {

    enum class WheelType {
        WINTER, SUMMER
    }
}

