package com.vadimkarch.dbpractice.task4.abstractFactory

interface CarPartsFactory {

    fun createEngine(): Engine
    fun createBody(): Body
    fun createWheel(): Wheel
}