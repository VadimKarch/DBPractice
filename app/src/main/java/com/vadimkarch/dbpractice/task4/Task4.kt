package com.vadimkarch.dbpractice.task4

import com.vadimkarch.dbpractice.task4.abstractFactory.Car2
import com.vadimkarch.dbpractice.task4.abstractFactory.ElectricCarPartsFactory
import com.vadimkarch.dbpractice.task4.abstractFactory.SportCarPartsFactory
import com.vadimkarch.dbpractice.task4.builder.Car
import com.vadimkarch.dbpractice.task4.builder.CarEngine
import com.vadimkarch.dbpractice.task4.builder.CarWheel


fun main() {
    val car1 = Car.Builder()
        .setManufacturer("Toyota")
        .setModel("Camry")
        .setYear(2024)
        .setColor("Black")
        .setMileage(2000)
        .setEngine(volume = 2.0f, horsePower = 173, fuelType = CarEngine.FuelType.PETROL)
        .setBody(type = "Sedan", doorsQuantity = 4)
        .setWheels(List(4) { CarWheel(size = "215/60/R16", type = CarWheel.WheelType.SUMMER) })
        .build()

    println(car1)

    val car2 = Car2
        .Assembler(ElectricCarPartsFactory())
        .assemble()

    println(car2)

    val car3 = Car2
        .Assembler(SportCarPartsFactory())
        .assemble()

    println(car3)
}