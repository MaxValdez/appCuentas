package com.example.calculos

class Calculos() : CalculosInterface {
    override fun sumar(actual: Double, nuevo: Double): Double = actual+nuevo

    override fun restar(actual: Double, nuevo: Double): Double = actual-nuevo
}