package com.vadimkarch.dbpractice.task4.builder

data class Car(
    val manufacturer: String,
    val model: String,
    val year: Int,
    val color: String,
    val mileage: Int,
    val carEngine: CarEngine,
    val carBody: CarBody,
    val carWheels: List<CarWheel>
) {

    class Builder {

        private var manufacturer: String = ""
        private var model: String = ""
        private var year: Int = 0
        private var color: String = ""
        private var mileage: Int = 0

        private var carEngine: CarEngine? = null
        private var carBody: CarBody? = null
        private var carWheels: MutableList<CarWheel> = mutableListOf()

        fun setManufacturer(manufacturer: String) = apply { this.manufacturer = manufacturer }
        fun setModel(model: String) = apply { this.model = model }
        fun setYear(year: Int) = apply { this.year = year }
        fun setColor(color: String) = apply { this.color = color }
        fun setMileage(mileage: Int) = apply { this.mileage = mileage }

        fun setEngine(volume: Float, horsePower: Int, fuelType: CarEngine.FuelType) =
            apply { this.carEngine = CarEngine(volume, horsePower, fuelType) }

        fun setBody(type: String, doorsQuantity: Int) =
            apply { this.carBody = CarBody(type, doorsQuantity) }

        fun addWheel(size: String, type: CarWheel.WheelType) =
            apply { this.carWheels.add(CarWheel(size, type)) }

        fun setWheels(carWheels: List<CarWheel>) =
            apply { this.carWheels = carWheels.toMutableList() }

        fun build(): Car {
            val engine = requireNotNull(carEngine)
            val body = requireNotNull(carBody)
            require(carWheels.size == 4)

            return Car(manufacturer, model, year, color, mileage, engine, body, carWheels.toList())
        }
    }
}