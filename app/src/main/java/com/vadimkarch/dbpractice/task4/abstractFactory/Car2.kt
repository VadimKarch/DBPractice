package com.vadimkarch.dbpractice.task4.abstractFactory

data class Car2(
    val engine: Engine,
    val body: Body,
    val wheel: List<Wheel>
) {

    class Assembler(private val factory: CarPartsFactory) {

        fun assemble(): Car2 {
            val engine = factory.createEngine()
            val body = factory.createBody()
            val wheels = List(4) { factory.createWheel() }

            return Car2(engine, body, wheels)
        }
    }
}