package com.vadimkarch.dbpractice.task4.abstractFactory

class SportCarPartsFactory : CarPartsFactory {

    override fun createEngine(): Engine = SportEngine()

    override fun createBody(): Body = SportBody()

    override fun createWheel(): Wheel = SportWheel()
}