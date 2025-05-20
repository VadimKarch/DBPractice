package com.vadimkarch.dbpractice.task4.abstractFactory

class ElectricCarPartsFactory : CarPartsFactory {

    override fun createEngine(): Engine = ElectricEngine()

    override fun createBody(): Body = ElectricBody()

    override fun createWheel(): Wheel = ElectricWheel()
}