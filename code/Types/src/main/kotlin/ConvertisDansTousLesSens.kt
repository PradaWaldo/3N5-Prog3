package org.pradavelasque

fun main(args: Array<String>) {
    var intToFloat: Float = 45.toFloat()
    println(intToFloat)

    val doubleToInt: Int = 42.99.toInt()
    println(doubleToInt)

    val stringToInt: Int = "4299".toInt()
    println(stringToInt)

    val intToString: String = 42.toString()
    println(intToString)

    val floatToDouble: Double = 3.14f.toDouble()
    println(floatToDouble)
}